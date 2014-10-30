package com.example.intenttest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends Activity {

	private EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		editText = (EditText)findViewById(R.id.editText);
		
		editText.setText("Action:" + getIntent().getAction() + "\n\n"
				         + "Category:" + getIntent().getCategories() + "\n\n"
				         + "Type: " + getIntent().getType() + "\n\n"
				         + "Data: " + getIntent().getData());
		
		
	}
}
