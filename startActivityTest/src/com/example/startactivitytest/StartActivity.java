package com.example.startactivitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mian_layout);
	}
	
	public void next(View v)
	{
		Intent intent = new Intent(StartActivity.this, SecondaryActivity.class);
		startActivity(intent);
	}
}
