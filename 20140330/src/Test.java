import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;




public class Test
{
	private static FileOutputStream output;
	private static FileInputStream input;
	
	private static int time = 1;
//	private static String patten;
	
	public static void printAll(File file)
	{
		String patten = "";
		for (int i = 0; i < time-1; i++)
		{
			patten += "  ";
		}
		
		System.out.println(patten + file.getName());
		patten += "  ";

		File[] f = file.listFiles();
		for (File f1 : f)
		{
			if (f1.isDirectory() && f1.listFiles().length !=0){
				 time++;
				 printAll(f1);
				 time--;
			}
			else System.out.println(patten + f1.getName());
		}
	}
	public static void deleteAll(File file)
	{
		File[] f = file.listFiles();
		for (File f1 : f)
		{
			if (f1.isFile() || f1.list().length == 0) f1.delete();
			else if (f1.isDirectory()) deleteAll(f1);
			f1.delete();
			
		}
		
	}

	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		File parent = new File("C:/abc"); 
		
		printAll(parent);
		//deleteAll(parent);
		

		
		
		
	
		
		
//		printAll(parent);
		
		
		
//		File file = new File(parent, "tets.txt");
//		file.createNewFile();
		
		
		
//		try {
//			output = new FileOutputStream("1.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		DataOutputStream outStream = new DataOutputStream(output);
//		
//		int j = 1000;
//		outStream.writeInt(j);
//		
//		output.close();
//		outStream.close();
//		
//		try {
//			input = new FileInputStream("1.txt");			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		DataInputStream inputStream = new DataInputStream(input);
//		
//		int i = inputStream.readInt();
//		System.out.println(i);
//		
//		input.close();
//		inputStream.close();
		
		
		
		
	}
	
	
	
	
	
	
}