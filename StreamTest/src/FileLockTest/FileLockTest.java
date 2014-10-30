package FileLockTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.io.File;

public class FileLockTest {
	public static void main(String[] args) throws IOException {
		
	//	FileInputStream file = new FileInputStream("C:\\Documents and Settings\\HTG\\workspace\\StreamTest" +File.separator + 
	//	                                            "src/bufferMapTest/test.txt");
//		System.out.println(new File("src/bufferMapTest/test.txt").length());
		
		RandomAccessFile file = new RandomAccessFile(new File("C:\\Documents and Settings\\HTG\\workspace\\StreamTest" +File.separator + 
                "src/bufferMapTest/test.txt"), "rw");

		
		FileChannel channel = file.getChannel();
		
		FileLock lock = channel.lock();
		//FileLock lock = channel.lock();
		System.out.println("readLock is " + lock);
		
		
		
//		System.out.println("lock is shared lock? : " + lock.isShared());
		if (lock != null) 
		{
		    //lock.release();
			System.out.println("lock.release() invoked");
		}
		while (true);
		
		
	}

}