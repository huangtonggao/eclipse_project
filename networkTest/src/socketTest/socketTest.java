package socketTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class socketTest {
	public static void main(String[] args) throws IOException, InterruptedException {
//		InetAddress clientIP = InetAddress.getByName("192.168.1.102");
//		System.out.println(clientIP);
		
		Socket s = new Socket("192.168.1.102", 6000);
		
		InputStream inStream = s.getInputStream();
		Scanner in = new Scanner(inStream);
		
		while(in.hasNextLine())
		{
			String str = in.nextLine();
			if (str.contains("Welcome"))
			{
				System.out.println("receive the server");
				break;
			}
		}
		
		OutputStream outStream = s.getOutputStream();
		PrintWriter out = new PrintWriter(outStream, true);
		
		try {
			int count = 0;
			while(count++ < 100)
			{
				out.write("count: " + count + "\r\n");
				out.flush();
				System.out.println("count: " + count);
				
				Thread.sleep(1000);
			}
			
		} finally
		{
			s.close();
		}
		
	}

}
