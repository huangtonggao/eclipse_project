package com.example.clocktest;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Chronometer chronometer = (Chronometer)findViewById(R.id.chronometer);
		chronometer.setBase(SystemClock.elapsedRealtime());
		
		chronometer.start();
		
		while (SystemClock.elapsedRealtime() - chronometer.getBase() < 20*1000);
		

		
		chronometer.stop();
	}
}
