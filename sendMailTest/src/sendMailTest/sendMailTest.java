package sendMailTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class sendMailTest {
	
	private String comm;
	private Scanner scanner;
	private PrintWriter writer;
	

	
	private void send(String str)
	{
		comm += str;
		comm += "\n";
		writer.print(str.replace("\n", "\r\n") + "\r\n");
//		writer.print("\r\n");
		writer.flush();		
	}
	private void receive()
	{
		String line = scanner.nextLine();
		comm += line;
		comm += "\n";
		
		System.out.println(comm);
	}
	
	public void sendMail() throws UnknownHostException, IOException
	{
		comm = "";
		
//		Socket sock = new Socket("mail.yourserver.com", 25);
		Socket sock = new Socket("smtp.126.com", 25);
		
		System.out.println(sock.isConnected());
		
		InputStream input = sock.getInputStream();
		OutputStream output = sock.getOutputStream();
		
		scanner = new Scanner(input);
		writer = new PrintWriter(output, true);
		
		receive();
		
		
		String hostName = InetAddress.getLocalHost().getHostName();
		
		send("HELO " + hostName);
		receive();
		
		send("auth login");
		receive();
		send("aHVhbmd0b25nZ2FvQDEyNi5jb20=");
		receive();
		send("aHVhbmc2ODg2MTk=");
		receive();
		
		
		send("MAIL FROM: <" + "huangtonggao@126.com" + ">");
		receive();
		
		send("RCPT TO: <" + "huangtonggao@126.com" + ">");
		receive();
		
		send("DATA");
		receive();
		
		send("what is ");		
		send("\n.");
		receive();
		
		sock.close();	
		
	}
	
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		sendMailTest mailTest = new sendMailTest();
		
		mailTest.sendMail();
		
		
	}
	
	

}
