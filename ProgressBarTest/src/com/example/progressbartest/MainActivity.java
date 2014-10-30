package com.example.progressbartest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	private int status;
	private ProgressBar bar;
	
	Handler handler = new Handler(){
		
		@Override
		public void handleMessage(Message msg)
		{
			if (msg.what == 0x123)
			{
				bar.setProgress(status);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bar = (ProgressBar)findViewById(R.id.bar);
		
		new Thread()
		{
			public void run()
			{
				while (status < 100)
				{
					status++;
					handler.sendEmptyMessage(0x123);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}.start();
		
	}
}
