package sliderTest;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.util.*;
import java.util.Hashtable;

public class test {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				sliderTest frame = new sliderTest();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class sliderTest extends JFrame
{
	public sliderTest()
	{
		setTitle("slideTest");
	    setSize(300,200);
	    sliderPanel = new JPanel();
	    field = new JTextField("20");
	    
	    slider = new JSlider(0, 100, 20);
	    slider.setMinorTickSpacing(5);
	    slider.setMajorTickSpacing(20);
	    slider.setPaintTicks(true);  //��ʾ��������/��С���
	    
	    slider.setSnapToTicks(true);  //�򿪶�����
	    
	    
	    Hashtable<Integer, Component> labelTable = new Hashtable<Integer, Component>();
	    labelTable.put(0, new JLabel("A"));
	    labelTable.put(20, new JLabel("B"));
	    labelTable.put(40, new JLabel("C"));
	    labelTable.put(60, new JLabel("D"));
	    labelTable.put(80, new JLabel("E"));
	    labelTable.put(100, new JLabel("F"));
	    
	    slider.setLabelTable(labelTable);
	    
	    slider.setPaintLabels(true);  //��ʾ����ߵ�label
	    
	    slider.setPaintTrack(false); //���ع켣
	    
	    //slider.setInverted(true); //������
	    
	    
	    
	    listener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				field.setText(((Integer)(slider.getValue())).toString());
				//System.out.println(slider.getValue());
			}
		};
		slider.addChangeListener(listener);
	    
		sliderPanel.add(new JLabel("0"));
	    sliderPanel.add(slider);
	    sliderPanel.add(new JLabel("100"));

	    add(sliderPanel, BorderLayout.CENTER);
	    add(field, BorderLayout.SOUTH);
	}
	
	
	
	
	private JSlider slider;
	private JPanel sliderPanel;
	private ChangeListener listener;
	private JTextField field;
}
