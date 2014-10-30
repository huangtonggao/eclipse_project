package ScatterGather;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterGatherTest {
	
	public static void main(String[] args) throws IOException {
	
		FileInputStream fileIn = new FileInputStream("src/ScatterGather/in.txt");
		FileOutputStream fileOut = new FileOutputStream("src/ScatterGather/out.txt");
		
		FileChannel channelIn = fileIn.getChannel();
		FileChannel channelOut = fileOut.getChannel();
		
		ByteBuffer[] arrayBuffer = new ByteBuffer[3];
		arrayBuffer[0] = ByteBuffer.allocate(5);
		arrayBuffer[1] = ByteBuffer.allocate(10);
		arrayBuffer[2] = ByteBuffer.allocate(20);
		
		arrayBuffer[0].clear();
		arrayBuffer[1].clear();
		arrayBuffer[2].clear();
		channelIn.read(arrayBuffer);
		
		
		arrayBuffer[0].flip();
		arrayBuffer[1].flip();
		arrayBuffer[2].flip();
		System.out.println("limit: " + arrayBuffer[0].limit() + " " + arrayBuffer[1].limit() + " " + arrayBuffer[2].limit());
		while(arrayBuffer[0].hasRemaining())
		{
			System.out.print(arrayBuffer[0].get());
		}
		System.out.println();
		
		while(arrayBuffer[1].hasRemaining())
		{
			System.out.print(arrayBuffer[1].get());
		}
		System.out.println();

		
		while(arrayBuffer[2].hasRemaining())
		{
			System.out.print(arrayBuffer[2].get());
		}
		System.out.println();

		
	}
	
	

}
