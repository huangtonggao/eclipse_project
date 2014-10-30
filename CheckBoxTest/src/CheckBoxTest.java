import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CheckBoxTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				CheckBoxFrame frame = new CheckBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}

}

class CheckBoxFrame extends JFrame
{
	public CheckBoxFrame()
	{
		setTitle("CheckBoxTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JPanel fontPanel = new JPanel();
		label = new JLabel("this is a checkBox test");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_FONT_SIZE));
		fontPanel.add(label);
		add(fontPanel, BorderLayout.CENTER);	
		
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int mode = 0;
				if (bold.isSelected()) mode += Font.BOLD;
				if (italic.isSelected()) mode += Font.ITALIC;
				label.setFont(new Font("Serif", mode, DEFAULT_FONT_SIZE));				
			}
		};
		bold = new JCheckBox("bold");
		italic = new JCheckBox("italic");	
		bold.addActionListener(listener);
		italic.addActionListener(listener);
		
		JPanel southPanel = new JPanel();
		southPanel.add(bold);
		southPanel.add(italic);
		add(southPanel, BorderLayout.SOUTH);
		
		
	}
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private static final int DEFAULT_FONT_SIZE = 20;
	
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
}
