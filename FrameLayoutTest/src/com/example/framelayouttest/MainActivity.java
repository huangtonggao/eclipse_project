package com.example.framelayouttest;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	private int currentColor = 0;
	
	final int[] colors = {Color.YELLOW, Color.RED, Color.GREEN};
	
	final int[] names = {R.id.text1, R.id.text2, R.id.text3};
	
	TextView views[] = new TextView[names.length];
	
	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg)
		{
			if (msg.what == 0x123)
			{
				for (int i = 0; i < names.length; i++)
				{
					views[i].setBackgroundResource(colors[i+(currentColor % names.length)]);
				}
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		for (int i = 0; i < names.length; i++)
		{
			views[i] = (TextView)findViewById(names[i]);
		}
		
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				handler.sendEmptyMessage(0x123);
			}
			
		}, 0, 1000);
	}

	
	
	
}
