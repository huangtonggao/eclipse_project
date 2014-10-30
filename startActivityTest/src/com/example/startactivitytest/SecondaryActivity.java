package com.example.startactivitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondary_layout);
	}
	
	public void prev1(View v)
	{
		Intent intent = new Intent(SecondaryActivity.this, StartActivity.class);
		startActivity(intent);
	}
	
	public void prev2(View v)
	{
		Intent intent = new Intent(SecondaryActivity.this, StartActivity.class);
		startActivity(intent);
		
		finish();
	}
	
	public void finish(View v)
	{
		finish();
	}

}
