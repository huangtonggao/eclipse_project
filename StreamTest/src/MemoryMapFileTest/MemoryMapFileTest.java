package MemoryMapFileTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMapFileTest {
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("F:\\JAVA\\Java编程思想(第4版).pdf");
		
		FileChannel channel = file.getChannel();
		
		MappedByteBuffer mappedBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
		
		System.out.println(mappedBuffer.capacity());
		System.out.println(mappedBuffer.limit());
		System.out.println(mappedBuffer.position());
		
		channel.close();
		
		
		
		
		
	}

}
