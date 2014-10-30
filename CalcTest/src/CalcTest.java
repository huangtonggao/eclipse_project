import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalcTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()		    
		{
			public void run()
			{
				CalcFrame frame = new CalcFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		}
		
		);
	}

}

class CalcFrame extends JFrame
{
	public CalcFrame()
	{
		setTitle("Calc");
		CalcPanel panel = new CalcPanel();
		add(panel);
		pack();
	}

	
}

class CalcPanel extends JPanel
{
	public CalcPanel()
	{
		result = 0;
		lastCommand = "=";
		start = true;
		
		setLayout(new BorderLayout());
		
		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new Command();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);
		
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);
		
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);

		addButton("0", insert);
		addButton(".", command);
		addButton("=", command);
		addButton("+", command);
		
		add(panel, BorderLayout.CENTER);
		
		
		
	}
	
	private void addButton(String label, ActionListener listener)
	{
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	private class InsertAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String input = event.getActionCommand();
			if (start)
			{
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}
	}
	
	private class Command implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			
			if (start)
			{
				if (command.equals("-"))
				{
					display.setText("-");
					start = false;
				}
				lastCommand = command;
			}
			else
			{
				if (display.getText().equals("-"))
				{
					//display.setText("");
					//lastCommand = command;
					
				}
				else
				{
					double data = Double.parseDouble(display.getText());
				    calculate(data);
				    lastCommand = command;
				    start = true;
				}
				
			}
		}
	}
	
	public void calculate(double x)
	{
		if (lastCommand.equals("+")) result += x;
		else if (lastCommand.equals("-")) result -= x;
		else if (lastCommand.equals("*")) result *= x;
		else if (lastCommand.equals("/")) result /= x;
		else if (lastCommand.equals("=")) result = x;
		display.setText("" + result);
	}
	
	
	private JPanel panel;
	private JButton display;
	private double result;
	private String lastCommand;
	private boolean start;
}
