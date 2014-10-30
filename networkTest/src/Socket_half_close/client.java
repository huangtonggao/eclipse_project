package Socket_half_close;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("192.168.1.102", 8189);
		
		PrintWriter out = new PrintWriter(client.getOutputStream());
		
		Scanner in = new Scanner(client.getInputStream());
		
		out.println("Please transfer the data");
		out.flush();
		
		client.shutdownOutput();
		
		FileWriter outFile = new FileWriter("src/Socket_half_close/receive.txt");		
		
		while (in.hasNextLine())
		{
			String str = in.nextLine();
			System.out.println("client: " + str);
			outFile.append(str);		
		}
		
		System.out.println("client receive ok");
		outFile.close();
		client.close();
		
		
	}

}
