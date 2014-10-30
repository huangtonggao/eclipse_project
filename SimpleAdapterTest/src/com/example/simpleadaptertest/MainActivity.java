package com.example.simpleadaptertest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	private String[] names = new String[]
			{"Jordan", "Messi", "Jackson", "Swift"};
	private String[] descs = new String[]
			{"God of the Basketball", "God of the football", "God of the Pop music", "God of the courtry music"};
	private int[] imageIds = new int[]
			{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};
	
	private String TAG = "SimpleAdapterTest";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Map<String, Object>> listItems = 
				new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < names.length; i++)
		{
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("header", imageIds[i]);
			listItem.put("personName", names[i]);
			listItem.put("desc", descs[i]);
			listItems.add(listItem);
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
														listItems,
														R.layout.simple_item,
														new String[]{"personName", "header", "desc"},
														new int[]{R.id.name, R.id.header, R.id.desc});
		ListView list = (ListView)findViewById(R.id.mylist);
		
		list.setAdapter(simpleAdapter);
		
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "position = " + position + "  id = " + id + " View = " + view.toString());
				
			}
			
		});		
		
	}
}


