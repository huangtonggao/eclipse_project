package com.example.viewswithcertest;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
	
	public static final int NUMBER_PER_SCREEN = 12;
	
	public static class DataItem
	{
		public String dataName;
		public Drawable drawable;
	}
	
	private ArrayList<DataItem> items = new ArrayList<DataItem>();
	
	private int screenNo = -1;
	private int screenCount;
	ViewSwitcher switcher;
	
	LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inflater = LayoutInflater.from(MainActivity.this);
		
		for (int i = 0; i < 40; i++)
		{
			String label = "" + i;
			Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
			
			DataItem item = new DataItem();
			item.dataName = label;
			item.drawable = drawable;
			items.add(item);
		}
		
		screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
						items.size() / NUMBER_PER_SCREEN :
						items.size() / NUMBER_PER_SCREEN + 1;
						

		switcher = (ViewSwitcher)findViewById(R.id.viewSwitcher);
		
		switcher.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				// TODO Auto-generated method stub				
				return inflater.inflate(R.layout.slidelistview, null);				
			}
		});
		
		next(null);	
	}
	
	public void next(View v)
	{
		if (screenNo < screenCount - 1)
		{
			screenNo++;
			
			switcher.setInAnimation(this, android.R.anim.slide_in_left);
			
			switcher.setOutAnimation(this, android.R.anim.slide_out_right);
			
			((GridView)switcher.getNextView()).setAdapter(adapter);
			
			switcher.showNext();
		}
	}
	
	public void prev(View v)
	{
		if (screenNo > 0)
		{
			screenNo--;
			
			switcher.setInAnimation(this, android.R.anim.slide_in_left);
			
			switcher.setOutAnimation(this, android.R.anim.slide_out_right);
			
			((GridView)switcher.getNextView()).setAdapter(adapter);
			
			switcher.showPrevious();
		}
	}
	
	private BaseAdapter adapter = new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = convertView;
			
			if (view == null)
			{
				inflater.inflate(R.layout.labelicon, null);
			}
			
			ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
			imageView.setImageDrawable(getItem(position).drawable);
			
			TextView textView = (TextView)view.findViewById(R.id.textView);
			textView.setText(getItem(position).dataName);
			
			return view;
		}
		
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public DataItem getItem(int position) { //获取指定position的data item
			// TODO Auto-generated method stub
			return items.get(screenNo * NUMBER_PER_SCREEN + position);
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if (screenNo == screenCount -1 && screenNo % NUMBER_PER_SCREEN != 0)
			{
				return screenNo % NUMBER_PER_SCREEN;
			}
			else
			{
				return NUMBER_PER_SCREEN;
			}
		}
	};
}




















