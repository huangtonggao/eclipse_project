import java.awt.*;
import java.awt.event.*;
import java.beans.EventHandler;

import javax.swing.*;


public class ButtonTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				frame.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						int newState = e.getNewState();
						int oldState = e.getOldState();
						System.out.println("close event invoked");
					}
					
					public void windowActivated(WindowEvent e)
					{
						int newState = e.getNewState();
						int oldState = e.getOldState();

						System.out.println("window actived invoked");
					}
					
					public void windowDeactivated(WindowEvent e)
					{
						System.out.println("window deactivated invoked");
						
					}
					
					public void windowIconified(WindowEvent e)
					{
						System.out.println("window iconified invoked");
					}
					public void windowDeiconified(WindowEvent e)
					{
						System.out.println("window deiconified invoked");
					}			
					
				});
				
				frame.addWindowStateListener(new myWindowState());
			}
		}
				
		);
	}

}

class myWindowState implements WindowStateListener
{
	public void windowStateChanged(WindowEvent e)
	{
		System.out.println("window state changed invoked");
	}
}

class ButtonFrame extends JFrame
{
	public ButtonFrame()
	{
		setTitle("ButtonTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JButton yellowButton = new JButton("yellow");
		JButton blueButton = new JButton("blue");
		JButton redButton = new JButton("red");
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.black);
		
		buttonPanel.setLayout(new BorderLayout());
		
		//setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		
		//buttonPanel.add(yellowButton, BorderLayout.SOUTH);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
	
		add(buttonPanel, BorderLayout.SOUTH);
		
	
		
		ColorAction yellowAction = new ColorAction(Color.yellow);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
		
		JButton btn = new JButton("test");
		buttonPanel.add(btn);
		
		
		label = new JLabel("count");
		add(label, "North");
		btn.addActionListener((ActionListener) EventHandler.create(ActionListener.class, this,
		        "backgroundSet"));
		
	}
	
	public void backgroundSet()
	{
		//System.out.println("this is test");
		//label.setText("hello");
	}
	

	
	private class ColorAction implements ActionListener
	{
		public ColorAction(Color c)
		{
			backgroundColor = c;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			buttonPanel.setBackground(backgroundColor);
			//getContentPane().setBackground(Color.yellow);
		}
		
		private Color backgroundColor;
	}
	
	
	private JPanel buttonPanel;
	private JLabel label;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200; 
}
