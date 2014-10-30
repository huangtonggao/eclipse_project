package com.example.imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	int[] iamges = new int[]{
			R.drawable.test1,
			R.drawable.test2,
			R.drawable.ic_launcher,
	};
	
	int currentImage = 1;
	private int alpha = 255;
	
	private final String TAG = "ImageView";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		final LinearLayout layout = (LinearLayout)findViewById(R.id.LinearLayout1);
		Log.i(TAG,"layout.getWidht() = " + layout.getWidth());
		Log.i(TAG,"layout.getHeight() = " + layout.getHeight());
		
		final Button plus = (Button)findViewById(R.id.plus);
		final Button minus = (Button)findViewById(R.id.minus);
		final Button next = (Button)findViewById(R.id.next);
		final ImageView image1 = (ImageView)findViewById(R.id.imageView1);
		final ImageView image2 = (ImageView)findViewById(R.id.imageView2);
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image1.setImageResource(iamges[currentImage++ % iamges.length]);
				
			}
		});
		
		OnClickListener listener = new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v == plus)
				{
					alpha += 20;
				}
				if (v == minus)
				{
					alpha -= 20;
				}
				if (alpha > 255)
				{
					alpha = 255;
				}
				if (alpha < 0)
				{
					alpha = 0;
				}
				
				image1.setAlpha(alpha);
				
			}
		};
		plus.setOnClickListener(listener);
		minus.setOnClickListener(listener);
		
		image1.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				BitmapDrawable bitmapDrawable = (BitmapDrawable)image1.getDrawable();
				
				Bitmap bitmap = bitmapDrawable.getBitmap();
				double scale = bitmap.getWidth()/320.0;
				
				int x = (int)(event.getX()*scale);
				int y = (int)(event.getY()*scale);
				
				Log.i(TAG,"pre x = " + x);
				Log.i(TAG,"pre y = " + y);
				Log.i(TAG,"scale = " + scale);
				
				if (x + 120 > bitmap.getWidth())
				{
					x = bitmap.getWidth() - 120;
				}
				if (y + 120 > bitmap.getHeight())
				{
					y = bitmap.getHeight() - 120;
				}
				Log.i(TAG,"after x = " + x);
				Log.i(TAG,"after y = " + y);
				Log.i(TAG,"getWidht() = " + bitmap.getWidth());
				Log.i(TAG,"getHeight() = " + bitmap.getHeight());
				
				image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));	
				
				return false;
			}
		});
		
		
		
		
	}
}
