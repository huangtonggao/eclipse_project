
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.util.*;

public class SimpleFrameTest
{
	public static void main(String[] args)
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit.getScreenSize();
		int screenWidth = screensize.width;
		int screenHeight = screensize.height;
		
		
		
		SimpleFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocation(200,200);
		frame.setSize(screensize.width/2, screensize.height/2);
		frame.setTitle("Screen size is " + screenWidth + "*" + screenHeight);
		
		//frame.setLocation(800,360);
		frame.setLocationByPlatform(true);
		
		Image img = kit.getImage("./IMG_20131124_163751.jpg");
		frame.setIconImage(img);
		frame.toFront();
		frame.setVisible(true);
		
		
	}
	

}


class SimpleFrame extends JFrame
{
	public SimpleFrame()
	{
		setSize(DEFAULT_WITHD,DEFAULT_HEIGHT);
	}
	
	public static final int DEFAULT_WITHD = 300;
	public static final int DEFAULT_HEIGHT = 300;
	
	

}

