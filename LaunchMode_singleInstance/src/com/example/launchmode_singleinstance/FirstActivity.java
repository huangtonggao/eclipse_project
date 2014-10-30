package com.example.launchmode_singleinstance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		
		TextView tv = new TextView(this);
		tv.setText("Activity为" + this.toString() + "\n" 
				    + "TaskID为" + getTaskId());
		ll.addView(tv);
		
		Button btn = new Button(this);
		btn.setText("点击启动第二个Activity");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//				startActivity(intent);
				
				Intent intent = new Intent();
				intent.setAction("com.example.laucnmode_singleinstance.intent.action");
				startActivity(intent);
				
			}
		});
		
		ll.addView(btn);
		
		setContentView(ll);
	
	}
}
