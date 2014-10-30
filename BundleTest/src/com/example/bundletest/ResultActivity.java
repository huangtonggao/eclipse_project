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
		
		name.setText("��������Ϊ�� " + p.getName());
		password.setText("��������Ϊ�� " + p.getPassword());
		gender.setText("�����Ա�Ϊ�� " + p.getGender());
		
		
	}
}
