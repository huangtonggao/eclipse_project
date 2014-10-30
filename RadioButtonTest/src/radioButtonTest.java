import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class radioButtonTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				radioButtonFrame frame = new radioButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}

}

class radioButtonFrame extends JFrame
{
	public radioButtonFrame()
	{
		setTitle("radioButtonFrame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JPanel fontPanel = new JPanel();
		label = new JLabel("this is a checkBox test");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_FONT_SIZE));
		fontPanel.add(label);
		add(fontPanel, BorderLayout.CENTER);	
		
		radioButtonPanel = new JPanel();
		buttonGroup = new ButtonGroup();
		
		addRadioButton("small", 12);
		addRadioButton("medium", 18);
		addRadioButton("large", 22);
		addRadioButton("Extra large", 30);


		add(radioButtonPanel, BorderLayout.SOUTH);
		
		
	}
	
	private void addRadioButton(String name, final int fontSize)
	{
		JRadioButton button = new JRadioButton(name, fontSize == DEFAULT_FONT_SIZE);		
		
	    ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				label.setFont(new Font("Serif", Font.PLAIN, fontSize));
			}
		};
		button.addActionListener(listener);
		buttonGroup.add(button);
		radioButtonPanel.add(button);
	}
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private static final int DEFAULT_FONT_SIZE = 18;
	
	private JLabel label;
	private JPanel radioButtonPanel;
	private ButtonGroup buttonGroup;

}
