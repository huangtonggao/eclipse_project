package com.example.tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost tabHost = getTabHost();
		
		TabSpec tab1 = tabHost.newTabSpec("tab1")
				.setIndicator("未接电话")
				.setContent(R.id.tab1);
		tabHost.addTab(tab1);
		
		TabSpec tab2 = tabHost.newTabSpec("tab2")
				.setIndicator("已拨电话")
				.setContent(R.id.tab1);
		tabHost.addTab(tab2);

		TabSpec tab3 = tabHost.newTabSpec("tab3")
				.setIndicator("已接电话")
				.setContent(R.id.tab1);
		tabHost.addTab(tab3);

		
	}
}
