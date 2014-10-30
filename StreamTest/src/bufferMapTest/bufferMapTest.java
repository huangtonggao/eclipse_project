package bufferMapTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileLock;

public class bufferMapTest {
	public static void main(String[] args) throws IOException {
		
//		FileOutputStream out = new FileOutputStream("src/bufferMapTest/test.txt");
		FileWriter write = new FileWriter("src/bufferMapTest/test.txt");
		write.write("123456");
		
		write.close();
		
		FileOutputStream outFile = new FileOutputStream("src/bufferMapTest/test.txt", true);
	    
		FileChannel outChannel = outFile.getChannel();
		FileLock outLock = outChannel.lock();	//获得独占锁，且没有释放	
		
		outFile.close();
		System.out.println("outLock is " + outLock);
		outLock.release();
		
		FileInputStream file = new FileInputStream("src/bufferMapTest/test.txt");
//		System.out.println(new File("src/bufferMapTest/test.txt").length());

		
		FileChannel channel = file.getChannel();
		
//		FileLock lock = channel.lock(0, 2, true);
//		System.out.println("readLock is " + lock);
//		
////		System.out.println("lock is shared lock? : " + lock.isShared());
//		
//		lock.release();
		
		MappedByteBuffer readBuffer = channel.map(MapMode.READ_ONLY, 0, channel.size());

		System.out.println("capacity:" + readBuffer.capacity());
		System.out.println("limit: " + readBuffer.limit());
		
		for (int i = 0; i < 3; i ++)
		{
			System.out.print((char)readBuffer.get());
		}
		System.out.println();
		System.out.println("position: " + readBuffer.position());
		readBuffer.mark();
		
//		readBuffer.rewind();
		readBuffer.reset();
		System.out.println("position: " + readBuffer.position());
		
//		readBuffer.flip();
		
		
		
		while (readBuffer.hasRemaining())
		{
			
			System.out.print((char)readBuffer.get());
		}
		System.out.println();
//		
//		System.out.println(readBuffer.order() == ByteOrder.BIG_ENDIAN);
		
		
		
		file.close();
		
		while(true);
		
		
	}

}
