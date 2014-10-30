package com.example.bundletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class BundleTest extends Activity {
	
	private EditText name;
	private EditText password;
	private RadioButton male;
	private Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bundle_test);
		
		name = (EditText)findViewById(R.id.name);
		password = (EditText)findViewById(R.id.password);
		male = (RadioButton)findViewById(R.id.male);
		btn = (Button)findViewById(R.id.btn);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (name.getText().toString().equals("") || password.getText().toString().equals(""))
				{
					Toast.makeText(BundleTest.this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
					return;
				}
				
				String gender = male.isChecked() ? "男" : "女";
				Person p = new Person(name.getText().toString(),
									   password.getText().toString(),
									   gender);
				
				Bundle bundle = new Bundle();
				bundle.putSerializable("person", p);
				Intent intent = new Intent(BundleTest.this, ResultActivity.class);
				
				intent.putExtras(bundle);
				
				startActivity(intent);
				
			}
		});
	}
}
