package com.example.imagebuttontest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.QuickContactBadge;

public class MainActivity extends Activity {

	QuickContactBadge badage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		badage = (QuickContactBadge)findViewById(R.id.badge);
		badage.assignContactFromPhone("15861813308", false);
	}
}
