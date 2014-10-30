import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class ComboBOxTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				ComboBoxFrame frame = new ComboBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}

}

class ComboBoxFrame extends JFrame
{
	public ComboBoxFrame()
	{
		setTitle("comboBoxTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JPanel fontPanel = new JPanel();
		label = new JLabel("this is a comboBox test");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_FONT_SIZE));
		fontPanel.add(label);
		add(fontPanel, BorderLayout.CENTER);	
		
		comboBoxPanel = new JPanel();
		
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		
		comboBox.addItem("Serif");
		comboBox.addItem("Monospace");
		comboBox.addItem("Dialog");

		
		comboBoxPanel.add(comboBox);
		
	    ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				label.setFont(new Font((String)comboBox.getSelectedItem(), Font.PLAIN, DEFAULT_FONT_SIZE));
				System.out.println("index is " + comboBox.getSelectedIndex());
			}
		};
		comboBox.addActionListener(listener);


		add(comboBoxPanel, BorderLayout.SOUTH);
		
		
	}
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private static final int DEFAULT_FONT_SIZE = 18;
	
	private JLabel label;
	private JPanel comboBoxPanel;
	private JComboBox comboBox;



}
