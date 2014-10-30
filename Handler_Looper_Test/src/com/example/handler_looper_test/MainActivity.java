package com.example.handler_looper_test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button btn;
	private EditText textView;
	private CalThread calThread;
	
	private final String UPPER_NUM = "upper";
	
	class CalThread extends Thread
	{
		public Handler handler;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Looper.prepare();
			handler = new Handler()
			{
				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					super.handleMessage(msg);
					
					if (msg.what == 0x123)
					{
						int upper = msg.getData().getInt(UPPER_NUM);
						
						List<Integer> nums = new ArrayList<Integer>();
						
						outer:
						for (int i = 2; i <= upper; i++)
						{
							for (int j = 2; j < i; j++)
							{
								if (i != 2 && i % j == 0)
								{
									continue outer;
								}								
							}
							
							nums.add(i);
						}
						
						Toast.makeText(MainActivity.this, nums.toString(), Toast.LENGTH_LONG).show();
					}
				}
				
			};
			
			Looper.loop();
			
			
			super.run();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button)findViewById(R.id.btn);
		textView = (EditText)findViewById(R.id.textView);
		
		calThread = new CalThread();
		calThread.start();
	}
	
	public void cal(View v)
	{
		Message msg = new Message();
		msg.what = 0x123;
		
		Bundle bundle = new Bundle();
		bundle.putInt(UPPER_NUM, Integer.parseInt(textView.getText().toString()));
		
		msg.setData(bundle);
		calThread.handler.sendMessage(msg);
	}
}















