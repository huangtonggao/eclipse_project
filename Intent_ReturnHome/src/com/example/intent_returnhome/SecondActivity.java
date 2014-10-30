package com.example.intent_returnhome;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		textView = (TextView)findViewById(R.id.textView);
		
		textView.setText("getAction = " + getIntent().getAction() + "\n\n" 
				  		  + "getCategories = " + getIntent().getCategories() + "\n\n"
				  		  + "getData = " + getIntent().getData() + "\n\n"
				  		  + "getType = " + getIntent().getType() + "\n\n");
	}
}
