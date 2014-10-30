package com.example.backgroundcolortest;

import java.util.HashMap;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	private int[] btnArray = new int[]{
			R.id.btn1, R.id.btn2, R.id.btn3,
			R.id.btn4, R.id.btn5, R.id.btn6,
			R.id.btn7, R.id.btn8, R.id.btn9,
			R.id.btn10,R.id.btn11, R.id.btn12,
			R.id.btn13,R.id.btn14, R.id.btn15,
			R.id.btn16,R.id.btn17, R.id.btn18,
			R.id.btn19,R.id.btn20, R.id.btn21,
			R.id.btn22,R.id.btn23, R.id.btn24,
			R.id.btn25,R.id.btn26, R.id.btn27,
			R.id.btn28,R.id.btn29, R.id.btn30,
			R.id.btn31,R.id.btn32, R.id.btn33
	};
	
	private int[] btnArray4jielong2 = new int[]{  //Ϊ����2���������
			R.id.btn1, R.id.btn2, R.id.btn3,
			R.id.btn6, R.id.btn9, R.id.btn12,
			R.id.btn15, R.id.btn18, R.id.btn21,
			R.id.btn24,R.id.btn27, R.id.btn30,
			R.id.btn33,R.id.btn32, R.id.btn31,
			R.id.btn28,R.id.btn25, R.id.btn22,
			R.id.btn19,R.id.btn16, R.id.btn13,
			R.id.btn10,R.id.btn7, R.id.btn4,
			R.id.btn5,R.id.btn8, R.id.btn11,
			R.id.btn14,R.id.btn17, R.id.btn20,
			R.id.btn23,R.id.btn26, R.id.btn29
			
	};
	
	private int[] toneButtonArray = new int[]{
			R.id.btn8, R.id.btn11, R.id.btn14,
			R.id.btn17, R.id.btn20, R.id.btn23,
			R.id.btn26
	};
	
	private int[] tone = new int[]{
			R.raw.m1, R.raw.m2, R.raw.m3, R.raw.m4,
			R.raw.m5, R.raw.m6, R.raw.m7
	};
			
	
	
	private int colors[] = new int[]{
			R.color.white,
			R.color.ivory,
			R.color.lightyellow,
			R.color.yellow,
			R.color.snow,
			R.color.floralwhite,                               
			R.color.lemonchiffon,                              
			R.color.cornsilk,                                  
			R.color.seashell,                                  
			R.color.lavenderblush,                             
			R.color.papayawhip,                                
			R.color.blanchedalmond,                            
			R.color.mistyrose,                                 
			R.color.bisque,                                    
			R.color.moccasin,                                  
			R.color.navajowhite,                               
			R.color.peachpuff,                                 
			R.color.gold,                                      
			R.color.pink,                                      
			R.color.lightpink,                                 
			R.color.orange,                                    
			R.color.lightsalmon,                               
			R.color.darkorange,                                
			R.color.coral,                                     
			R.color.hotpink,                                   
			R.color.tomato,                                    
			R.color.orangered,                                 
			R.color.deeppink,                                  
			R.color.fuchsia,                                   
			R.color.magenta,                                   
			R.color.red,                                       
			R.color.oldlace,                                   
			R.color.lightgoldenrodyellow,                      
			R.color.linen,                                     
			R.color.antiquewhite,                              
			R.color.salmon,                                    
			R.color.ghostwhite,                                
			R.color.mintcream,                                 
			R.color.whitesmoke,                                
			R.color.beige,                                     
			R.color.wheat,                                     
			R.color.sandybrown,                                
			R.color.azure,                                     
			R.color.honeydew,                                  
			R.color.aliceblue,                                 
			R.color.khaki,                                     
			R.color.lightcoral,                                
			R.color.palegoldenrod,                             
			R.color.violet,                                    
			R.color.darksalmon,                                
			R.color.lavender,                                  
			R.color.lightcyan,                                 
			R.color.burlywood,                                 
			R.color.plum,                                      
			R.color.gainsboro,                                 
			R.color.crimson,                                   
			R.color.palevioletred,                             
			R.color.goldenrod,                                 
			R.color.orchid,                                    
			R.color.thistle,                                   
			R.color.lightgray,                                 
			R.color.lightgrey,                                 
			R.color.tan,                                       
			R.color.chocolate,                                 
			R.color.peru,                                      
			R.color.indianred,                                 
			R.color.mediumvioletred,                           
			R.color.silver,                                    
			R.color.darkkhaki,                                 
			R.color.rosybrown,                                 
			R.color.mediumorchid,                              
			R.color.darkgoldenrod,                             
			R.color.firebrick,                                 
			R.color.powderblue,                                
			R.color.lightsteelblue,                            
			R.color.paleturquoise,                             
			R.color.greenyellow,                               
			R.color.lightblue,                                 
			R.color.darkgray,                                  
			R.color.darkgrey,                                  
			R.color.brown,                                     
			R.color.sienna,                                    
			R.color.darkorchid,                                
			R.color.palegreen,                                 
			R.color.darkviolet,                                
			R.color.mediumpurple,                              
			R.color.lightgreen,                                
			R.color.darkseagreen,                              
			R.color.saddlebrown,                               
			R.color.darkmagenta,                               
			R.color.darkred,                                   
			R.color.blueviolet,                                
			R.color.lightskyblue,                              
			R.color.skyblue,                                   
			R.color.gray,                                      
			R.color.grey,                                      
			R.color.olive,                                     
			R.color.purple,                                    
			R.color.maroon,                                    
			R.color.aquamarine,                                
			R.color.chartreuse,                                
			R.color.lawngreen,                                 
			R.color.mediumslateblue,                           
			R.color.lightslategray,                            
			R.color.lightslategrey,                            
			R.color.slategray,                                 
			R.color.slategrey,                                 
			R.color.olivedrab,                                 
			R.color.slateblue,                                 
			R.color.dimgray,                                   
			R.color.dimgrey,                                   
			R.color.mediumaquamarine,                          
			R.color.cornflowerblue,                            
			R.color.cadetblue,                                 
			R.color.darkolivegreen,                            
			R.color.indigo,                                    
			R.color.mediumturquoise,                           
			R.color.darkslateblue,                             
			R.color.steelblue,                                 
			R.color.royalblue,                                 
			R.color.turquoise,                                 
			R.color.mediumseagreen,                            
			R.color.limegreen,                                 
			R.color.darkslategray,                             
			R.color.darkslategrey,                             
			R.color.seagreen,                                  
			R.color.forestgreen,                               
			R.color.lightseagreen,                             
			R.color.dodgerblue,                                
			R.color.midnightblue,                              
			R.color.aqua,                                      
			R.color.cyan,                                      
			R.color.springgreen,                               
			R.color.lime,                                      
			R.color.mediumspringgreen,                         
			R.color.darkturquoise,                             
			R.color.deepskyblue,                               
			R.color.darkcyan,                                  
			R.color.teal,                                      
			R.color.green,                                     
			R.color.darkgreen,                                 
			R.color.blue,                                      
			R.color.mediumblue,                                
			R.color.darkblue,                                  
			R.color.navy,                                      
			R.color.black 
	};
	
	private int workMode = 0; //����ģʽ��ģʽ0��һ����ɫ��˸��ģʽ1��������ɫ��˸���Ҹ���ģ�鲿ͬ��ɫ��ģʽ2��������ɫ�����˸
	private int workMode0Count = 0;
	private boolean runFlag0 = false;
	

	private int workMode1Count = 0;
	private boolean runFlag1 = false;
	

	private int workMode2Count = 0;
	private boolean runFlag2 = false;
	private int workMode2Index = 0;
	private int rotateFlag2 = 0;
	
	private int workMode3Count = 0;
	private boolean runFlag3 = false;
	private int workMode3Index = 0;
	private int rotateFlag3 = 0;
	
	private int delay = 250; //��ɫ�л���ʱ��������
	private int hideTextFlag = 0; //�������ĸ���ť����������
	
	private int rowNum = 0; //��Ļ�϶����У�onCreate����¸�ֵ
	
	private String musicString;  //���ڸ�������ģʽ�����ϵ��ַ���
	private Button toneButton; //����button��7������һ��
	private SoundPool soundPool;
	private  HashMap<Integer, Integer> toneMap;

	//���ֿ���,���ڵ��handler�У�������final�޶�
	private Button btn28;
	private boolean musicOnFlag = true;

	
	Handler handler = new Handler(){
		
		@Override
		public void handleMessage(Message msg) {
			
			if (msg.what == 0)
			{
				for (int i = 0; i < btnArray.length; i++)
				{
					Button b = (Button)findViewById(btnArray[i]);
					int c = getResources().getColor(colors[workMode0Count % colors.length]);
					b.setBackgroundColor(c);
				}
				workMode0Count++;			
			}
			else if (msg.what == 1)
			{
				for (int i = 0; i < btnArray.length; i++)
				{
					Button b = (Button)findViewById(btnArray[i]);
					int c = getResources().getColor(colors[workMode1Count++ % colors.length]);
					b.setBackgroundColor(c);
				}
					
			}
			else if (msg.what == 2)
			{
				
				if (rotateFlag2 == 0)
				{
					workMode2Index = workMode2Count;
					for (int i = 0; i < rowNum; i++)
					{
						Button b = (Button)findViewById(btnArray[i*3]);
						int c = getResources().getColor(colors[workMode2Index]);
						b.setBackgroundColor(c);
						
						b = (Button)findViewById(btnArray[i*3 + 1]);
						c = getResources().getColor(colors[workMode2Index]);
						b.setBackgroundColor(c);
						
						b = (Button)findViewById(btnArray[i*3 + 2]);
						c = getResources().getColor(colors[workMode2Index]);
						b.setBackgroundColor(c);
						
						workMode2Index++;						
					}
					
					workMode2Count++;
					if (workMode2Count + rowNum == colors.length) //������ɫ����������
					{
						rotateFlag2 = 1;
					}						
				}
				else if (rotateFlag2 == 1)
				{
					workMode2Index = workMode2Count - rowNum;
					for (int i = 0; i < rowNum; i++)
					{
						Button b = (Button)findViewById(btnArray[i*3]);
						int c = getResources().getColor(colors[workMode2Index]);
						b.setBackgroundColor(c);
						
						b = (Button)findViewById(btnArray[i*3 + 1]);
						c = getResources().getColor(colors[workMode2Index % colors.length]);
						b.setBackgroundColor(c);
						
						b = (Button)findViewById(btnArray[i*3 + 2]);
						c = getResources().getColor(colors[workMode2Index % colors.length]);
						b.setBackgroundColor(c);
						
						workMode2Index++;		

						
					}
					
					workMode2Count--;
					if (workMode2Count - rowNum == -1) //������ɫ����������
					{						
						rotateFlag2 = 0;
					}						
				}
				
				Log.i("Mode2", "workMode2Count = " + workMode2Count);	
			}
			else if (msg.what == 3)  //����2
			{
				if (rotateFlag3 == 0)
				{
					workMode3Index = workMode3Count;
					for (int i = 0; i < btnArray.length; i++)
					{
						Button b = (Button)findViewById(btnArray4jielong2[i]);
						int c = getResources().getColor(colors[workMode3Index]);
						b.setBackgroundColor(c);
						
						
						workMode3Index++;						
					}
					
					workMode3Count++;
					if (workMode3Count + btnArray.length == colors.length) //������ɫ����������
					{
						rotateFlag3 = 1;
					}						
				}
				else if (rotateFlag3 == 1)
				{
					workMode3Index = workMode3Count - btnArray.length;
					for (int i = 0; i < btnArray.length; i++)
					{
						Button b = (Button)findViewById(btnArray4jielong2[i]);
						int c = getResources().getColor(colors[workMode3Index]);
						b.setBackgroundColor(c);
						
						workMode3Index++;		

						
					}
					
					workMode3Count--;
					if (workMode3Count - btnArray.length == -1) //������ɫ����������
					{						
						rotateFlag3 = 0;
					}						
				}
				
				Log.i("Mode3", "workMode3Count = " + workMode3Count);	
			}
			
	    }
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btn28 = (Button)findViewById(R.id.btn28);
		
		toneMap = new HashMap<Integer, Integer>();
		// ������������10����Ƶ��,��Ƶ��Ʒ��Ϊ5  
        soundPool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);  
        
		rowNum = btnArray.length / 3; //��Ļ�ϵ�����
		
		// ��ȡ��Ļ�ܶȣ�����1��  
		int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();       // ��Ļ�����أ��磺480px��  
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();      // ��Ļ�ߣ����أ��磺800p��  
		  
		//Log.i("getDefaultDisplay", "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);  
		/*for (int i = 0; i < btnArray.length; i++)
		{
			Button b = (Button)findViewById(btnArray[i]);
			//b.setMinHeight(screenHeight/rowNum);
			//b.setHeight(screenHeight/rowNum);
			Log.i("Test", "height=" + b.getHeight());
		}*/
		/*Button b = (Button)findViewById(R.id.btn1);
		b.setHeight(10);
		int minHeight = b.getMinHeight();
		Log.i("getDefaultDisplay", "minHeight = " + minHeight);  */
		
		/*LinearLayout ll=(LinearLayout)this.findViewById(R.id.tableLayout); 
		android.view.ViewGroup.LayoutParams lp =ll.getLayoutParams(); 
		lp.height=100;*/
		
		/*TableRow t = (TableRow)findViewById(R.id.tableRow1);
		t.setLayoutParams(new TableRow.LayoutParams(screenWidth, 10));*/
		
		toneButtonHandler toneHandler = new toneButtonHandler();
		for (int i = 0; i < 7; i++)
		{
			toneButton = (Button)findViewById(toneButtonArray[i]);
			toneButton.setOnClickListener(toneHandler);
			
			toneMap.put(i, soundPool.load(this, tone[i], 1));
		}
		
		btn28.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (musicOnFlag == true)
				{
					musicOnFlag = false;
				    if (((Button)findViewById(R.id.btn30)).getText().equals("����"))
				    {
				    	btn28.setText("������");
				    }
					
					musicString = "������";
					
				}
				else
				{
					musicOnFlag = true;
					if (((Button)findViewById(R.id.btn30)).getText().equals("����"))
					{
						btn28.setText("������");						
					}
					musicString = "������";
				}
				
			}
		});

		
		
		//ģʽ0
		((Button)findViewById(btnArray[0])).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (runFlag0) //���Thread�Ѿ�����ģʽ0�ˣ��򷵻�
				{
					return;
				}
				
				runFlag0 = true;
				workMode = 0;

				
				new Thread()
				{
					public void run()
					{						
						while(workMode == 0)
						{
							handler.sendEmptyMessage(workMode);
							try {
								Thread.sleep(delay);  //��ʱgt
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						runFlag0 = false;		
					}
				
				}.start();
				
			}
		});
		
		//��ɫ
		((Button)findViewById(btnArray[1])).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				if (runFlag1) //���Thread�Ѿ�����ģʽ1�ˣ��򷵻�
				{
					return;
				}
				
				runFlag1 = true;
				workMode = 1;

				
				new Thread()
				{
					public void run()
					{						
						while(workMode == 1)
						{
							handler.sendEmptyMessage(workMode);
							try {
								Thread.sleep(delay);  //��ʱ
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						runFlag1 = false;		
					}
				
				}.start();
				
			}
		});
		
		//����1
		((Button)findViewById(btnArray[2])).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (runFlag2) //���Thread�Ѿ�����ģʽ2�ˣ��򷵻�
				{
					return;
				}
				
				runFlag2 = true;
				workMode = 2;

				
				new Thread()
				{
					public void run()
					{						
						while(workMode == 2)
						{
							handler.sendEmptyMessage(workMode);
							try {
								Thread.sleep(delay);  //��ʱ
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						runFlag2 = false;		
					}
				
				}.start();
				
			}
		});		
		
		//����2
		((Button)findViewById(btnArray[3])).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (runFlag3) //���Thread�Ѿ�����ģʽ3�ˣ��򷵻�
				{
					return;
				}
				
				runFlag3 = true;
				workMode = 3;

				
				new Thread()
				{
					public void run()
					{						
						while(workMode == 3)
						{
							handler.sendEmptyMessage(workMode);
							try {
								Thread.sleep(delay);  //��ʱ
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						runFlag3 = false;		
					}
				
				}.start();
				
			}
		});		
		
		((Button)findViewById(btnArray[btnArray.length-1])).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				workMode = -1;  //���һ��Button��ͣ������

				
			}	
			
		});
		
		//�����ڶ�������������delay
		((Button)findViewById(btnArray[btnArray.length-2])).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				delay += 50;
				if (delay > 1500)
				{
					delay = 1500;
				}
				
			}	
			
		});
		//������3����������Сdelay
		((Button)findViewById(btnArray[btnArray.length-3])).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				delay -= 50;
				if (delay < 100)
				{
					delay = 100;
				}
				
			}	
			
		});
		
		//������4����������������
		((Button)findViewById(btnArray[btnArray.length-4])).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Button b = null;
				if (hideTextFlag % 2 == 0) 
				{
					hideTextFlag = 1;
					//����
					b = (Button)findViewById(btnArray[0]);
					b.setText("");
					b = (Button)findViewById(btnArray[1]);
					b.setText("");
					b = (Button)findViewById(btnArray[2]);
					b.setText("");
					b = (Button)findViewById(btnArray[3]);
					b.setText("");
					b = (Button)findViewById(btnArray[btnArray.length - 1]);
					b.setText("");
					b = (Button)findViewById(btnArray[btnArray.length - 2]);
					b.setText("");
					b = (Button)findViewById(btnArray[btnArray.length - 3]);
					b.setText("");
					b = (Button)findViewById(btnArray[btnArray.length - 6]);
					b.setText("");
					b = (Button)findViewById(btnArray[btnArray.length - 4]);
					b.setText("��ʾ");
					
				}
				else
				{
					hideTextFlag = 0;
					b = (Button)findViewById(btnArray[0]);
					b.setText("ͬɫ");
					b = (Button)findViewById(btnArray[1]);
					b.setText("��ɫ");
					b = (Button)findViewById(btnArray[2]);
					b.setText("����1");
					b = (Button)findViewById(btnArray[3]);
					b.setText("����2");
					b = (Button)findViewById(btnArray[btnArray.length - 6]);
					b.setText(musicString);
					b = (Button)findViewById(btnArray[btnArray.length - 3]);
					b.setText("����");
					b = (Button)findViewById(btnArray[btnArray.length - 2]);
					b.setText("����");
					b = (Button)findViewById(btnArray[btnArray.length - 1]);
					b.setText("ֹͣ");
					b = (Button)findViewById(btnArray[btnArray.length - 4]);
					b.setText("����");
				}
				
			}	
			
		});	
		
	}
	
	public class toneButtonHandler implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button b = (Button)v;
			
			if (musicOnFlag == false)
			{
				return;
			}
			
			
			switch (b.getId())
			{
				case R.id.btn8:
				{
					soundPool.play(toneMap.get(0), 1, 1, 0, 0, 1);
					break;
				}
				case R.id.btn11:
				{
					soundPool.play(toneMap.get(1), 1, 1, 0, 0, 1);
					break;
				}
				case R.id.btn14:
				{
					soundPool.play(toneMap.get(2), 1, 1, 0, 0, 1);
					break;
				}
				case R.id.btn17:
				{
					soundPool.play(toneMap.get(3), 1, 1, 0, 0, 1);
					break;
				}
				case R.id.btn20:
				{
					soundPool.play(toneMap.get(4), 1, 1, 0, 0, 1);
					break;
				}
				case R.id.btn23:
				{
					soundPool.play(toneMap.get(5), 1, 1, 0, 0, 1);
					break;
				}
				case R.id.btn26:
				{
					soundPool.play(toneMap.get(6), 1, 1, 0, 0, 1);
					break;
				}
				default:
				{
					Log.e("Error", b.getId() + " is out of range");
				}
			}
			
		}
		
	}
	

	
}
