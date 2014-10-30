
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class actionTest
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				myAction frame = new myAction();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
}

class myAction extends JFrame
{
	
	public myAction()
	{
		setTitle("ActionTest");
		setSize(300,200);
		
		buttonPanel = new JPanel();
		
		ColorAction blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		JButton blueButton = new JButton(blueAction);
				
		buttonPanel.add(blueButton);
		
		ColorAction redAction = new ColorAction("Red", new ImageIcon("blue-ball.gif"), Color.RED);
		JButton redButton = new JButton(redAction);
				
		buttonPanel.add(redButton);	
		
		add(buttonPanel);
		
		InputMap imp = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imp.put(KeyStroke.getKeyStroke("ctrl Y"), "panel blue");
		imp.put(KeyStroke.getKeyStroke("ctrl X"), "panel red");
		
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel blue", blueAction);
		amap.put("panel red", redAction);
		
		
	}



	class ColorAction extends AbstractAction
	{
		public ColorAction(String name, Icon icon, Color c)
		{
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue("color", c);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to" + name.toLowerCase());
			
		}
		
		public void actionPerformed(ActionEvent event)
		{

			buttonPanel.setBackground((Color)getValue("color"));
		}
	}
	
	private JPanel buttonPanel;
	

}


