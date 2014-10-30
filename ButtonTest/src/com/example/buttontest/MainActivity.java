package com.example.buttontest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	RadioGroup radioGroup;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
		textView = (TextView)findViewById(R.id.textView1);
		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				String tip = checkedId == R.id.male ?
						     "您的性别是男人" : "您的性别是女人";
				textView.setText(tip);
				
			}
		});
	}
}
