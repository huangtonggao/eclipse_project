
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class BlockingQueueTest {
	public static void main(String[] args) {
		
		String directory = "C:\\Documents and Settings\\HTG\\workspace\\20140329";
		File f = new File(directory);
		ArrayBlockingQueue<File> queue = new ArrayBlockingQueue<>(1);
		new Thread(new FileEnumerationTest(queue, f)).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(queue);
		
		searchKeyword search = new searchKeyword("p", queue);
		for (int i = 0; i < 100; i++)
		{
			Thread t = new Thread(search);
			t.start();
		}		
	}

}

class FileEnumerationTest implements Runnable
{
	

	public FileEnumerationTest(ArrayBlockingQueue<File> queue,
			File startingDirectory) {
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}
	@Override
	public void run() {
		try {
			enumerate(this.startingDirectory);		
			queue.put(DUMMY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void enumerate(File directory) throws InterruptedException
	{
		File[] file = directory.listFiles();
		for (File f : file)
		{
			if (f.isDirectory()) {
				enumerate(f);
			}
			else
			{
				queue.put(f);
			}
		}
	}
	public static File DUMMY = new File("");
	private ArrayBlockingQueue<File> queue;
	private File startingDirectory;
	
}


class searchKeyword implements Runnable
{	
	public searchKeyword(String keyword, ArrayBlockingQueue<File> queue) {
		this.keyword = keyword;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			boolean flag = false;
			
			while (!flag)
			{
				File file = queue.take();
				if (file == FileEnumerationTest.DUMMY)
				{
					queue.put(file);
					flag = true;
				}
				else
				{
					serach(file);
				}
			}
			
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
	}
	
	public void serach(File file) throws FileNotFoundException
	{
		Scanner in = new Scanner(new FileInputStream(file));
		int lineNumber = 0;
		while(in.hasNextLine())
		{
			lineNumber++;
			String line = in.nextLine();
			if (line.contains(keyword))
			{
				System.out.println(file.getPath() + " " + lineNumber + " : " + line);
			}
			
		}
		in.close();
	}
	
	
	private String keyword;
	private ArrayBlockingQueue<File> queue;
	
}













