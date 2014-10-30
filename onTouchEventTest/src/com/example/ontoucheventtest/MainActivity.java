package com.example.ontoucheventtest;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editText;
	private Configuration configuration;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = (EditText)findViewById(R.id.editText);
		
		configuration = getResources().getConfiguration();
		
		
		
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		float x = event.getX();
		float y = event.getY();

		editText.setText("x = " + x + " y = " + y);
		
		Log.i("Test", "fontScale = " + configuration.fontScale);
		Log.i("Test", "mmc = " + configuration.mcc);
		Log.i("Test", "mnc = " + configuration.mnc);
		Log.i("Test", "orientation = " + configuration.orientation);
		Log.i("Test", "touchscreen = " + configuration.touchscreen);
		Log.i("Test", "screenWidthDp  = " + configuration.screenWidthDp );
		Log.i("Test", "screenHeightDp   = " + configuration.screenHeightDp  );
		
		
		return super.onTouchEvent(event);
	}
}
