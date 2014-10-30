import java.awt.*;
/*import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;*/
import java.awt.event.*;
import javax.swing.*;


public class mouseTest {
	public static void main(String[] args)
	{
		MouseEvent_1 frame = new MouseEvent_1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}

class MouseEvent_1 extends JFrame
{
	public MouseEvent_1()
	{
		setTitle("MouseTest");
		setBounds(0, 0, 300, 200);
		
		addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("mouseClicked");
			}
			public void mousePressed(MouseEvent e)
			{
				System.out.println("mousePressed");
			}
			public void mouseReleased(MouseEvent e)
			{
				System.out.println("mouseReleased");
			}
			public void mouseEntered(MouseEvent e)
			{
				System.out.println("mouseEntered");
			}
			public void mouseExited(MouseEvent e)
			{
				System.out.println("mouseExited");
			}
			
		});
		
		addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent e)
			{
				System.out.println("MouseDragged");
			}
			public void mouseMoved(MouseEvent e)
			{
				System.out.println("MouseMoved");
			}
		});
		
	}
}
