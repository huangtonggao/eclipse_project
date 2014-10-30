package com.example.arrayadaptertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] array1 = {"�����", "��˽�","ţħ��"};		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.array_item, array1);
		
		ListView list1 = (ListView)findViewById(R.id.list1);
		list1.setAdapter(adapter);
			
	}
}
