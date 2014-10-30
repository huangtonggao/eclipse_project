package com.example.baseadaptertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView myList;
	
	int[] showImages = new int[]{
			R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myList = (ListView)findViewById(R.id.myList);
		
		BaseAdapter adapter = new BaseAdapter()
		{

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 4;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout line = new LinearLayout(MainActivity.this);
				line.setOrientation(0);
				
				ImageView image = new ImageView(MainActivity.this);
				image.setImageResource(showImages[position]);
				TextView text = new TextView(MainActivity.this);
				text.setText("第" + (position+1) + "个列表项");
				text.setTextSize(20);
				line.addView(image);
				line.addView(text);
				
				return line;
			}
			
		};
		
		myList.setAdapter(adapter);
		
	}
}
