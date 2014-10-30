import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TextComponentTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				TextComponent frame = new TextComponent();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}


class TextComponent extends JFrame
{
	public TextComponent()
	{
		setTitle("TextComponentTest");
		setSize(400,400);
		
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		
		
		add(northPanel, BorderLayout.NORTH);
		
		final JTextArea textArea = new JTextArea(8, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		//textArea.setWrapStyleWord(true);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		
		JButton insertButton = new JButton("insert");
		insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.append("User name: " + textField.getText() + " Password: " 
						+ new String(passwordField.getPassword()) + '\n');
				
			}
		});
		southPanel.add(insertButton);
		add(southPanel, BorderLayout.SOUTH);
		
		
		
		
	}
}