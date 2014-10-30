package com.example.intent_returnhome;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn;
	private Button btn2;
	private Button edit;
	private Button dial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button)findViewById(R.id.btn);
		btn2 = (Button)findViewById(R.id.btn2);
		edit = (Button)findViewById(R.id.edit);
		dial = (Button)findViewById(R.id.dial);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				
				startActivity(intent);
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setData(Uri.parse("lee://www.baidu.com"));
			//	intent.setAction("com.example.intent_return_home");
				
				startActivity(intent);
				
			}
		});
		
		edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_EDIT);
				
				String data = "content://com.android.contacts/contacts/111";				
				intent.setData(Uri.parse(data));
				
				startActivity(intent);
				
				
			}
		});
		
		dial.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_DIAL);
				
				String data = "tel:15861813308";				
				intent.setData(Uri.parse(data));
				
				startActivity(intent);
				
				
			}
		});
		
		
		
	}
}
