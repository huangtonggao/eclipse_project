package com.example.bundletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	private TextView name;
	private TextView password;
	private TextView gender;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		name = (TextView)findViewById(R.id.name);
		password = (TextView)findViewById(R.id.password);
		gender = (TextView)findViewById(R.id.gender);
		
		Intent intent = getIntent();
		
		Person p = (Person)intent.getSerializableExtra("person");
		
		name.setText("您的姓名为： " + p.getName());
		password.setText("您的密码为： " + p.getPassword());
		gender.setText("您的性别为： " + p.getGender());
		
		
	}
}
