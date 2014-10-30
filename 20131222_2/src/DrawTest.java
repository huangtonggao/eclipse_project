import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;

import java.awt.event.*;

import javax.swing.JButton;
import java.util.*;


public class DrawTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				DrawFrame frame = new DrawFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//frame.getContentPane().setBackground(Color.black); //…Ë÷√±≥æ∞
				
				frame.setVisible(true);
				
				
				
			}
		});
	}

}

class DrawFrame extends JFrame
{
	public DrawFrame()
	{
		setTitle("DrawTest");
		setSize(400, 400);
		
		DrawComponent component = new DrawComponent();
		add(component);
		//getContentPane().setBackground(SystemColor.desktop); //…Ë÷√±≥æ∞
		
		JButton btn = new JButton("btn");
		btn.setSize(20, 20);
		this.add(btn);
		
		ActionListener listener =  new myListener();
		btn.addActionListener(listener);
	}
}

class DrawComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;		
		
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		
		g2.setPaint(Color.red);
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(rect);
		//g2.fill(rect);
		
		Font sansbold14 = new Font("Monospaced", Font.BOLD + Font.ITALIC, 14);
		g2.setFont(sansbold14);
		g2.drawString("hello", 20, 30);
		
		String str = sansbold14.getFamily();  //∑µªÿ◊÷∑˚¥Æ£∫Monospaced
		
		FontRenderContext context1 = g2.getFontRenderContext();
		
		Font sansbold = new Font("Dialog", Font.BOLD, 14);
		g2.setFont(sansbold);
		FontRenderContext context2 = g2.getFontRenderContext();
		
		
		g2.setPaint(Color.yellow);
		
		
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		g2.setPaint((new Color(255,0,0)).brighter().brighter().brighter());
		
		Point2D p1 = new Point2D.Double(leftX, topY);
		Point2D p2 = new Point2D.Double(leftX + width/2, topY + height/2);
		g2.draw(new Line2D.Double(p1, p2));
		
		//g2.draw(new Line2D.Double(leftX, topY, leftX + width/2, topY + height/2));
		
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
		g2.draw(circle);		
		
		
	}
}



class myListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		System.out.println("this is test");
	}
	
}





