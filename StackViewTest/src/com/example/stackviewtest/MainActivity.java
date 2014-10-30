package com.example.stackviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

public class MainActivity extends Activity {

	private int[] images = new int[]{
			R.drawable.ic_launcher, R.drawable.ic_launcher1, R.drawable.p1, R.drawable.p2,
	};
	private StackView stackView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		stackView = (StackView)findViewById(R.id.stackView);
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < images.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", images[i]);
			listItems.add(map);
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
														listItems,
														R.layout.cell,
														new String[]{"image"},
														new int[]{R.id.cell_image});
		stackView.setAdapter(simpleAdapter);
			
	}
	
	public void next(View source)
	{
		stackView.showNext();
	}
	public void prev(View source)
	{
		stackView.showPrevious();
	}
}













