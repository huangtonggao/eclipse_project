import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;
import java.awt.EventQueue;

import javax.swing.*;

import java.util.prefs.Preferences;
import java.util.*;


public class PropertiesTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PropertiesFrame frame = new PropertiesFrame();
				frame.setVisible(true);
			}
		});
		
	}

}

class PropertiesFrame extends JFrame
{
	public PropertiesFrame()
	{
		Preferences usrRoot = Preferences.userRoot();
		Preferences sysRoot = Preferences.systemRoot();
		try
		{
			String[] str = usrRoot.childrenNames();
			System.out.println("length = " + str[0].length());
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		
		
		String userDir = System.getProperty("user.home");
		String osName = System.getProperty("line.separator");
		File propertiesDir = new File(userDir, ".core.java");  //文件和目录路径名的抽象表示形式，仅仅是个对象，还没建立文件
		if (!propertiesDir.exists()) propertiesDir.mkdir();  //建立文件夹
		propertiesFile = new File(propertiesDir, "program.properties");
		
		Properties defaultSettings = new Properties();
		defaultSettings.put("left", "0");
		defaultSettings.put("top", "0");
		defaultSettings.put("width", "300");
		defaultSettings.put("height", "200");
		defaultSettings.put("title", "");
		
		settings = new Properties(defaultSettings);  //defaultSettins作为二级索引，作为默认值
		
		if (propertiesFile.exists()) try  //exists() 测试此抽象路径名表示的文件或目录是否存在
		{
			FileInputStream in = new FileInputStream(propertiesFile);
			settings.load(in);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left, top, width, height);
		
		String title  = settings.getProperty("title");
		if (title.equals("")) title = JOptionPane.showInputDialog("Please supply a frame title");
		if (title == null) title = "";
		setTitle(title);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				settings.put("left", "" + getX());
				settings.put("top", "" + getY());
				settings.put("width", "" + getWidth());
				settings.put("height", "" + getHeight());
				settings.put("title", getTitle());
				try
				{
					FileOutputStream out = new FileOutputStream(propertiesFile);
					settings.store(out, "Program Properties");
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
				System.exit(0);				
				
			}
		});
		
		
		
		
	}
	
	private File propertiesFile;
	private Properties settings;
	
	
	
}



