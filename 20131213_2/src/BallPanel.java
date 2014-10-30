import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.util.*;

/**
 * BallPanel��һ���ɸ��õ�С����ײ���
 * @author zjf
 * @version 1.0 2011-1-11
 */
@SuppressWarnings("serial")
public class BallPanel extends JPanel 
{
	private ArrayList<Ball> balls = new ArrayList<Ball>();	//С���б�
	private BallComponent component = new BallComponent();	//С�򻭰�
	private JButton btnAdd = new JButton("Add");	//Add��ť
	private JButton btnStopAndContinue = new JButton("Stop");	//Stop��ť
	private JButton btnClear = new JButton("Clear");	//Clear��ť
	private JComboBox colorCombo = new JComboBox();	//��ɫѡ���
	private JComboBox speedCombo = new JComboBox();	//�ٶ�ѡ���
	private JComboBox placeCombo = new JComboBox();	//С����ַ�λ
	private BallThread thread = new BallThread();	//С���˶��߳�
	private int delay = 5;	//С���˶����ӻ�ʱ��
	
	/**
	 * ��ʼ��С�����
	 */
	public BallPanel()
	{
		setLayout(new BorderLayout());	//����ΪBorderLayout�Ĳ���
		add(component, BorderLayout.CENTER);	//��С�򻭰�ӵ��������
		component.setOpaque(true);				//���û��岻͸�����Ա�����ӱ���ɫ
		component.setBackground(Color.BLACK);	//���ñ���ɫ
		
		JPanel panel = new JPanel();	//���������Ÿ��ְ�ť�����
		panel.add(btnAdd);				//��Add��ť��������
		panel.add(btnStopAndContinue);	//��Stop/Continue��ť��������
		panel.add(btnClear);			//��Clear��ť��������
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.SOUTH);	//����ť���ӵ�������ϲ�
		
		panel = new JPanel(new GridLayout(0, 1));	//���������Ÿ���ѡ�������
		panel.add(new JLabel(" Color: "));	//��ӱ�ǩColor:
		panel.add(colorCombo);				//�����ɫѡ���
		panel.add(new JLabel(" Speed: "));	//��ӱ�ǩSpeed:
		panel.add(speedCombo);				//����ٶ�ѡ���
		panel.add(new JLabel(" From: "));	//��ӱ�ǩFrom:
		panel.add(placeCombo);				//��ӷ�λѡ���
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.EAST);		//��ѡ������ӵ�����嶫��
		
		//���¼��仰��������ɫѡ�����������ɫѡ��
		colorCombo.addItem("red");
		colorCombo.addItem("orange");
		colorCombo.addItem("yellow");
		colorCombo.addItem("green");
		colorCombo.addItem("cyan");
		colorCombo.addItem("blue");
		colorCombo.addItem("magenta");
		
		//���¼��仰�������ٶ�ѡ����������ٶ�ѡ��
		speedCombo.addItem("slow");
		speedCombo.addItem("fast");
		//�ٶ�ѡ���������������ʱ�ı�С����ٶ�
		speedCombo.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					String speed = (String)speedCombo.getSelectedItem();
					if (speed.equals("slow"))
					{
						delay = 5;
					}
					else
					{
						delay = 1;
					}
				}
			});
		
		//���¼��仰������λѡ��������ַ�λѡ��
		placeCombo.addItem("Left-Top");
		placeCombo.addItem("Left-Bottom");
		placeCombo.addItem("Right-Top");
		placeCombo.addItem("Right-Bottom");
		
		//Add��ť����������������°�ťʱ���С��
		btnAdd.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					component.addBall();
				}
			});
		//Stop/Continue��ť����������������°�ťʱ��ͣ/��������
		btnStopAndContinue.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					if (btnStopAndContinue.getText().equals("Stop"))	//�����ǰ��ť��ֵΪStop
					{
						thread.setStop(true);	//��stop��־��Ϊtrue
						btnStopAndContinue.setText("Continue");	//����ť�ı�ǩ��ΪContinue
						btnAdd.setEnabled(false);	//Add��ť������
					}
					else
					{
						thread.setStop(false);	//��stop��־��Ϊfalse
						btnStopAndContinue.setText("Stop");	//����ť�ı�ǩ��ΪStop
						btnAdd.setEnabled(true);	//Add��ť����
					}
				}
			});
		//Clear��ť����������������°�ťʱ��ջ���
		btnClear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					balls = new ArrayList<Ball>();	//������б����
					component.repaint();			//�ػ�����
				}
			});
		
		thread.start();	//��������߳̿�ʼ
	}
	
	/**
	 * ����������Ҫ���ڲ���
	 * @param args
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					JFrame frame = new JFrame("Hit Balls");	//���ò��Կ�ܵı���
					frame.add(new BallPanel());		//��С����ײ����������ȥ
					frame.setSize(400, 300);		//���ÿ�ܴ�С
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���ÿ�ܵ�Ĭ�Ϲرշ�ʽ
					frame.setLocationByPlatform(true);	//����ܵĶ�λ����ϵͳʵ��
					frame.setVisible(true);			//���ÿ�ܿɼ�
				}
			});
	}
	
	/**
	 * С���˶��߳�
	 * @author zjf
	 */
	private class BallThread extends Thread
	{
		private boolean isStop = false;	//ֹͣ���
		
		/**
		 * �߳���
		 */
		public void run()
		{
			while (true)	//����һֱִ��
			{
				if (!isStop)	//��û��ֹͣ��ʱ��
				{
					for (int i = 0; i < balls.size(); i++)
					{
						balls.get(i).move(component.getBounds());	//ÿ��С���ƶ�һ��
					}
					component.repaint();	//�ػ�����
				}
				try {
					Thread.sleep(delay);	//�߳��ӻ�delay����
				} catch (InterruptedException e) {	//�����쳣
					e.printStackTrace();	//�����쳣
				}
			}
		}
		
		/**
		 * ����stop��־
		 * @param isStop	�Ƿ�ֹͣ
		 */
		public void setStop(boolean isStop)
		{
			this.isStop = isStop;
		}
	}
	
	/**
	 * С��Ļ���
	 * @author zjf
	 */
	private class BallComponent extends JComponent
	{
		public BallComponent()
		{
			//˵ʵ�����Ҳ��Ǻ�������δ����Ǹ�ʲô�ģ�����Ҫ�õ�����ɫ�����õ���δ���
			setUI(new ComponentUI() 	
			{
				public void installUI(JComponent c)
				{
					super.installUI(c);
					LookAndFeel.installColors(c, "Panel.background",
							"Panel.foreground");
				}
			});
		}
		/**
		 * ���С��
		 */
		public void addBall()
		{
			double x = 0;	//С��ʼ��x����
			double y = 0;	//С��ʼ��y����
			String tmp = (String)placeCombo.getSelectedItem();	//�õ���λ��ѡ����
			if (tmp.equals("Left-Top"))	//���Ϊ����
			{
				x = component.getBounds().getMinX();	//x��Ϊ���������ߵ�ֵ
				y = component.getBounds().getMinY();	//y��Ϊ��������ϱߵ�ֵ
			}
			if (tmp.equals("Left-Bottom"))	//��ͬ
			{
				x = component.getBounds().getMinX();
				y = component.getBounds().getMaxY();
			}
			if (tmp.equals("Right-Top"))
			{
				x = component.getBounds().getMaxX();
				y = component.getBounds().getMinY();
			}
			if (tmp.equals("Right-Bottom"))
			{
				x = component.getBounds().getMaxX();
				y = component.getBounds().getMaxY();
			}
			
			Color color = Color.BLACK;	//С��ʼ����ɫ
			tmp = (String)colorCombo.getSelectedItem();	//�õ���ɫ��ѡ����
			if (tmp.equals("red"))	//���Ϊred
			{
				color = Color.RED;	//��ɫ��Ϊred
			}
			if (tmp.equals("orange"))	//��ͬ
			{
				color = Color.ORANGE;
			}
			if (tmp.equals("yellow"))
			{
				color = Color.YELLOW;
			}
			if (tmp.equals("green"))
			{
				color = Color.GREEN;
			}
			if (tmp.equals("cyan"))
			{
				color = Color.CYAN;
			}
			if (tmp.equals("blue"))
			{
				color = Color.BLUE;
			}
			if (tmp.equals("magenta"))
			{
				color = Color.MAGENTA;
			}
			balls.add(new Ball(x, y, color));	//��С����б��м���������ĳ�ʼ��λ����ɫΪǰ���ֵ
		}
		
		/**
		 * ���ƻ���
		 */
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			for (int i = 0; i < balls.size(); i++)	//��С���б��е�С�򶼻���������
			{
				Ball ball = balls.get(i);
				g2.setColor(ball.getColor());	//���û�����С�����ɫ
				g2.fill(ball.getShape());		//����С�����״
			}
		}
	}
	
	/**
	 * С����
	 * @author zjf
	 */
	private class Ball
	{
		private static final double SIZE = 20;	//С���ֱ��
		private double x = 0;	//С�����ڵ�x����
		private double y = 0;	//С�����ڵ�y����
		private double vx = Math.sqrt(2) / 2;	//С����x����ٶ�
		private double vy = Math.sqrt(2) / 2;	//С����y����ٶ�
		private Color color = Color.BLACK;		//С�����ɫ
		
		/**
		 * С��Ĺ��캯��
		 * @param x	С�����ڵ�x����
		 * @param y С�����ڵ�y����
		 * @param color С�����ɫ
		 */
		public Ball(double x, double y, Color color)
		{
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		/**
		 * С����һ�����α߿����ƶ�
		 * @param bounds ���α߿�
		 */
		public void move(Rectangle2D bounds)
		{
			x += vx;	//С����x���ϵ�λ��
			y += vy;	//С����y���ϵ�λ��
			double minX = bounds.getMinX();	//���α߽����Сx����
			double minY = bounds.getMinY();	//���α߽����Сy����
			double maxX = bounds.getMaxX();	//���α߽�����x����
			double maxY = bounds.getMaxY();	//���α߽�����y����
			if (x <= minX)	//���С��Խ����߽�
			{
				x = minX;	//С���x�����Ϊ���α߽����Сx����
				vx = -vx;	//С����x�᷽����ٶȷ���
			}
			if (y <= minY)	//���С��Խ���ϱ߽�
			{
				y = minY;	//С���y�����Ϊ���α߽����Сy����
				vy = -vy;	//С����y�᷽����ٶȷ���
			}
			if (x + SIZE >= maxX)	//���С��Խ���ұ߽�
			{
				x = maxX - SIZE;	//С���x�����Ϊ���α߽�����x�����ȥС���ֱ��
				vx = -vx;			//С����x�᷽����ٶȷ���
			}
			if (y + SIZE >= maxY)	//���С��Խ���±߽�
			{
				y = maxY - SIZE;	//С���y�����Ϊ���α߽�����y�����ȥС���ֱ��
				vy = -vy;			//С����y�᷽����ٶȷ���
			}
			for (int i = 0; i < balls.size(); i++)	//�ж�С����Ƿ�����ײ
			{
				Ball ball = balls.get(i);
				if (this.equals(ball))	//�Լ����Լ�����ײ
					continue;
				if ((ball.x - x) * (ball.x - x) + (ball.y - y) * (ball.y - y) <= SIZE * SIZE)	//�������ľ���С��ֱ��ʱ������Ϊ��С��������ײ
				{
					double degree = Math.atan((y - ball.y) / (x - ball.x));	//��ȡ�Լ��뷢����ײ��С��֮�����γɵļнǣ���Ϊ�н�ֻ����-pi/2-pi/2֮�䣬���Ի����ж������x����֮��Ĺ�ϵ
					if (x > ball.x)		//����Լ���x������ڷ�����ײ��С���x���꣬����ѧ֪ʶ��֪�Լ�Ӧ���������˶�
					{
						vx = Math.cos(degree);	
						vy = Math.sin(degree);
					}
					else	//����Լ���x����С�ڷ�����ײ��С���x���꣬����ѧ֪ʶ��֪Ӧ�ó������˶�
					{
						vx = -Math.cos(degree);
						vy = -Math.sin(degree);
					}
				}
			}
		}
		
		/**
		 * ��ȡС�����״
		 * @return ��״
		 */
		public Ellipse2D getShape()
		{
			return new Ellipse2D.Double(x, y, SIZE, SIZE);
		}
		
		/**
		 * ��ȡС�����ɫ
		 * @return ��ɫ
		 */
		public Color getColor()
		{
			return color;
		}
		
		/**
		 * �ж�����С���Ƿ���ͬ
		 */
		public boolean equals(Object object)
		{
			if (this == object) return true;	//�����ָ�Ķ�����ͬ������С���ȷ��ͬ
			if (object == null) return false;	//���Ҫ�Ƚϵ�С�򲻴��ڣ�����С��ͬ
			if (getClass() != object.getClass()) return false;	//����Լ�����������һ�������������ͬ������С��ͬ
			Ball ball = (Ball)object;			//����һ������ǿ��ת��ΪС��
			return x == ball.x && y == ball.y && color.equals(ball.color);	//ͨ����λ����ɫ�ж��Ƿ���ͬ
		}
	}
}
