package 批量修改文件名字;

import java.io.File;

public class batchRename {
	
	public static void main(String[] args) {
		
		File dir = new File("E:\\Picture\\2014\\MEMO\\family");
		
		File[] files = dir.listFiles();
		
		int count = 1;
		
		for (File f: files)
		{
			f.renameTo(new File("E:\\Picture\\2014\\MEMO\\family\\" + count + ".jpg"));
			
			count++;
		}
		
	}

}
