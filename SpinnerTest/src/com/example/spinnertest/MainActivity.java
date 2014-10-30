package com.example.spinnertest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private Spinner spinner;
	
	private String[] str = new String[]{
			"Jordan", "Michale", "Chester","Hello", "World"
	};

	@SuppressWarnings("deprecation")
	private Gallery gallery;
	/*private ImageView[] imageViews = new ImageView[]{
		(ImageView)findViewById(R.drawable.p1),(ImageView)findViewById(R.drawable.p2),
		(ImageView)findViewById(R.drawable.p3),(ImageView)findViewById(R.drawable.p4)
	};*/
	private int[] imageViews = new int[]{
			R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4
	};

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spinner = (Spinner)findViewById(R.id.spinner);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, str);
		
		spinner.setAdapter(adapter);
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < imageViews.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", imageViews[i]);
			listItems.add(map);
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
				new String[]{"name"}, new int[]{R.id.image});

		gallery = (Gallery)findViewById(R.id.gallery);
		gallery.setAdapter(simpleAdapter);
		

		
	}
}
