package com.example.togglebuttontest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	ToggleButton toggleButton;
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toggleButton = (ToggleButton)findViewById(R.id.toggle);
		layout = (LinearLayout)findViewById(R.id.LinearLayout1);
		
		CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
				{
					layout.setOrientation(1);
				}
				else
				{
					layout.setOrientation(0);
				}
			}
			
		};
		
		toggleButton.setOnCheckedChangeListener(listener);


	}
}
