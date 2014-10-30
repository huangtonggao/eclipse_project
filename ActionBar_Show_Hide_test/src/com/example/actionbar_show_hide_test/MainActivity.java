package com.example.actionbar_show_hide_test;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actionBar = getActionBar();

	}
	
	public void show(View v)
	{
		actionBar.show();
	}
	
	public void hide(View v)
	{
		actionBar.hide();
	}
	
}
