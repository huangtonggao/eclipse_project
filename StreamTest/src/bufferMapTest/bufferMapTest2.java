package bufferMapTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class bufferMapTest2 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("src/bufferMapTest/test.txt");
//		System.out.println(new File("src/bufferMapTest/test.txt").length());

		
		FileChannel channel = file.getChannel();
		
		FileLock lock = channel.lock(0, 2, true);
		System.out.println("readLock is " + lock);
		
//		System.out.println("lock is shared lock? : " + lock.isShared());
		if (lock != null) lock.release();
		
	}

}
