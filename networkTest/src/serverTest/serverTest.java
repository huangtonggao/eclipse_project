package serverTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverTest {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress("192.168.1.102", 6000));
		
		
		
		while(true)
		{
			Socket incoming = server.accept();
			System.out.println("accept the client");
			
			PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
			
			Scanner scanner = new Scanner(incoming.getInputStream());
			
			out.write("Welcome to you, " + incoming.getLocalAddress());
			out.flush();
			
			while (scanner.hasNextLine())
			{
				String str = scanner.nextLine();
				
				System.out.println(str);
				
				if (str.contains("end"))
				{
					System.out.println("close the link to client, " + incoming.getLocalAddress());
					incoming.close();
					
					break;
				}
				
			}	
			
			
			
		}
		
		
		
		
		
		
		
	}

}
