package Socket_half_close;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	
	public static void serverStart() throws IOException
	{
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress("192.168.1.102", 6000));
		System.out.println("server bind ok");
		
		while(true)
		{
			Socket incoming = server.accept();
			System.out.println("server link to client " + incoming.getLocalSocketAddress());
			
			ThreadProc proc = new ThreadProc(incoming);
		    Thread thread = new Thread(proc);
		    thread.start();			
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		server.serverStart();
		
	}

}

class ThreadProc implements Runnable
{
	private Socket incoming;
	

	public ThreadProc(Socket incoming) {
		this.incoming = incoming;
	}


	@Override
	public void run() {
		
		Scanner scanner = null;
		PrintWriter writer = null;
		
		try {
			scanner = new Scanner(incoming.getInputStream());
			writer = new PrintWriter(incoming.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.write("Welcome to you " + incoming.getLocalSocketAddress());
		writer.flush();
		while(scanner.hasNextLine())
		{
			String str = scanner.nextLine();
			System.out.println(str);
			
			if (str.contains("Please transfer the data"))
			{
				int count = 0;
				while(count++ < 100)
				{
					writer.write("count: " + count + "\r\n");
					writer.flush();
					
					try {
						Thread.sleep(50);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}			
				
				
				System.out.println("Data transfer ok");
				try {
					incoming.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}
		
	
		
		
		
		
	}
	
}



