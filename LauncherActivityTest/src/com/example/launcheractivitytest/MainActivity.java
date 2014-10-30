package com.example.launcheractivitytest;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends LauncherActivity {
	
	private String[] names = {"���ó������", "�鿴�Ǽʱ���"};
	
	Class<?>[] classes = {PreferenceActivityTest.class, ExpandableListActivityTest.class};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
		setListAdapter(adapter);		
	}
	
	@Override
	protected Intent intentForPosition(int position) {
		// TODO Auto-generated method stub		
		return  new Intent(MainActivity.this, classes[position]);
	}
}
