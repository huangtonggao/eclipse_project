package Socket_half_close;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class client1 {
	
	public static void threadProc() throws UnknownHostException, IOException
	{
//        Socket client = new Socket();
//        //client.setSoTimeout(10000);
//        client.connect(new InetSocketAddress("192.168.1.102", 6000), 10000);
		
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		channel.connect(new InetSocketAddress("192.168.1.102", 6000));
		
		PrintWriter out = new PrintWriter(Channels.newOutputStream(channel));
		
		Scanner in = new Scanner(channel);
		
		out.println("Please transfer the ");
		out.flush();
		
		//client.shutdownOutput();
		
		FileWriter outFile = new FileWriter("src/Socket_half_close/receive.txt");		
		
		while (in.hasNextLine())
		{
			String str = in.nextLine();
			System.out.println("client: " + str);
			//outFile.append(str);		
		}
		
		System.out.println("client receive ok");
		outFile.close();
		channel.close();
	}
	
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		Thread thread1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					client1.threadProc();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		});
		
		thread1.start();
		
		Thread.sleep(3000);
		
		thread1.interrupted();
		
		
		
		
	}

}
