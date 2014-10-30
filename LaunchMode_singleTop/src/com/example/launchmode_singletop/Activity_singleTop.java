package com.example.launchmode_singletop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_singleTop extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		
		layout.setOrientation(LinearLayout.VERTICAL);
		
		setContentView(layout);
		
		TextView textView = new TextView(this);
		textView.setText("Activity为" + this.toString() + "\n" + 
							"Task ID为" + getTaskId());
		layout.addView(textView);
		
		Button button = new Button(this);
		button.setText("点击以singleTop方式启动自己");
		layout.addView(button);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Activity_singleTop.this, Activity_singleTop.class);
				
				startActivity(intent);
			}
		});
		
		
		


		
		
	}


}
