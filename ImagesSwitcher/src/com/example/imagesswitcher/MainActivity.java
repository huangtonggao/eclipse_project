package com.example.imagesswitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
	
	private int[] imageIds = new int[]{
			R.drawable.p1, R.drawable.p2, R.drawable.p3,
			R.drawable.p4, R.drawable.p5, R.drawable.p6,
			R.drawable.p7, R.drawable.p8, R.drawable.p9,
			R.drawable.p10, R.drawable.p2, R.drawable.p3,
	};
	
	GridView gridView;
	ImageSwitcher switcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gridView = (GridView)findViewById(R.id.grid0);
		
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < imageIds.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("iamge", imageIds[i]);
			
			listItems.add(map);			
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, 
														listItems, R.layout.cell, 
														new String[]{"iamge"}, 
														new int[]{R.id.cellIamge});
		gridView.setAdapter(simpleAdapter);
		
		switcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
		
		switcher.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				ImageView imageView = new ImageView(MainActivity.this);
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				
				return imageView;

			}
		});
		
		gridView.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switcher.setImageResource(imageIds[position]);
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switcher.setImageResource(imageIds[position]);
				
			}
		});
		
		
		
		
		
	}
}
