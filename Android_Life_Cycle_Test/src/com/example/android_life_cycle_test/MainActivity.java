package com.example.android_life_cycle_test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	
	private static String TAG = "MainActivity"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "OnCreate");
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		Log.v(TAG, "onStart");
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		Log.v(TAG, "onResume");
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		Log.v(TAG, "onPause");
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		Log.v(TAG, "onStop");
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.v(TAG, "onDestory");
	}
	
	@Override
	protected void onRestart()
	{
		super.onRestart();
		Log.v(TAG, "onRestart");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
