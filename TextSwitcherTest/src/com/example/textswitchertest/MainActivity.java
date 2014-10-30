package com.example.textswitchertest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
	
	private String[] str = new String[]{
			"疯狂Java讲义", "疯狂的石头", "唐宋八大家", "苏门四学士", "初唐四杰",
	};
	
	private TextSwitcher textSwitcher;
	
	private int curStr = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textSwitcher = (TextSwitcher)findViewById(R.id.textSwitcher);
		
		textSwitcher.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				TextView tv = new TextView(MainActivity.this);
				tv.setTextSize(40);
				tv.setTextColor(Color.MAGENTA);
				return tv;
			}
		});
		
		next(null);
		
	}
	
	public void next(View v)
	{
		textSwitcher.setText(str[curStr++ % str.length]);
	}
}














