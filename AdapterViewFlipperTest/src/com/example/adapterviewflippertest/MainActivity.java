package com.example.adapterviewflippertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private int[] images = new int[]{
			R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4,
			R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,
			R.drawable.p9,R.drawable.p10,R.drawable.p11
	};
	private AdapterViewFlipper flipper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		flipper = (AdapterViewFlipper)findViewById(R.id.flipper);
		
		BaseAdapter baseAdapter = new BaseAdapter()
		{

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return images.length;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				ImageView imageView = new ImageView(MainActivity.this);
				
				imageView.setImageResource(images[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
				
				return imageView;
		
			}
			
		};
		
		flipper.setAdapter(baseAdapter);
		
		
	}
	
	public void prev(View source)
	{
		flipper.showPrevious();
		
		flipper.stopFlipping();
	}
	
	public void next(View source)
	{
		flipper.showNext();
		
		flipper.stopFlipping();
	}
	
	public void auto(View source)
	{
		flipper.startFlipping();
	}
}












