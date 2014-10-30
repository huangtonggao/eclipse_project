package com.example.activityforresulttest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example1.activityforresulttest.R;

public class MainActivity extends Activity {
	
	private Button btn;
	private TextView editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button)findViewById(R.id.btn);
		editText = (TextView)findViewById(R.id.editText);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setComponent(new ComponentName("com.example1.activityforresulttest", "com.example.ResultActivity"));
				
				startActivityForResult(intent, 1);
				
			}
		});
		
	}
	
	//接收ResultActivity Intent的回调函数
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == 1 && resultCode == 1)
		{
			Bundle bundle = data.getExtras();
			
			String resultCity = bundle.getString("city");
			
			editText.setText(resultCity);					
		}
		
	}
}











