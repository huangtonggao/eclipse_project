package FileTest;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
		File file = new File("afilethatprobablydoesntexist");
		File file1 = new File("C:\\Documents and Settings\\HTG\\workspace\\StreamTest\\afilethatprobablydoesntexist");
		file = file.getCanonicalFile();
		file1 = file1.getCanonicalFile();
		
		System.out.println(file.getTotalSpace());
		
		
		System.out.println(file.equals(file1));
		
//		file.getCanonicalFile();
//		file.deleteOnExit();
		System.out.println(file.getAbsolutePath());
		file.createNewFile();
		System.out.println(file.exists());
		
		
	}

}
