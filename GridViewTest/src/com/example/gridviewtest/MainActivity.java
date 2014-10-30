package com.example.gridviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	GridView grid;
	ImageView imageView;
	
	int[] images = new int[]{
			R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < images.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", images[i]);
			listItems.add(map);
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				listItems, R.layout.cell, new String[]{"image"},
				new int[]{R.id.cell});
		grid = (GridView)findViewById(R.id.grid1);
		grid.setAdapter(simpleAdapter);
		
		imageView = (ImageView)findViewById(R.id.imageView);
		
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				imageView.setImageResource(images[position]);
				
			}
		});
		
		
	}
}












