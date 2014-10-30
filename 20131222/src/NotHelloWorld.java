
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class NotHelloWorld
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				NotHelloWorldFrame frame = new NotHelloWorldFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}
}

class NotHelloWorldFrame extends JFrame
{
    public NotHelloWorldFrame()
    {
    	setTitle("NotHelloWorld");
    	setSize(300,200);
    	
    	Container container = getContentPane();
    	
    	NotHelloWorldPanel panel = new NotHelloWorldPanel();
    	//add(panel, BorderLayout.NORTH);   
    	container.add(panel);  //可以通过Container添加组件
    	
       	/*Button bn = new Button("bn");
       	Button bs = new Button("bs");
       	       	
    	add(bn, BorderLayout.NORTH);   	//可以通过JFrame直接添加组件，不需要生成Container对象
    	add(bs, BorderLayout.SOUTH);*/

    }
}

class NotHelloWorldPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		//g.drawString("Not hello world", 100, 100);
		
		double leftX= 10;
		double topY = 10;
		double width = 200;
		double height = 150;
		
		Graphics2D g2 = (Graphics2D)g;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		rect.add(300,300);
		double centerX = rect.getCenterX();
		System.out.println(centerX);
		g2.draw(rect);
		
		
		
		
	}
}






