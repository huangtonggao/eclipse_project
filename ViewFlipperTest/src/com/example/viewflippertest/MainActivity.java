package com.example.viewflippertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	private ViewFlipper flipper;
	
	private Button auotPlayBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		auotPlayBtn = (Button)findViewById(R.id.auotPlayBtn);
		flipper = (ViewFlipper)findViewById(R.id.details);
		
		ImageView image1 = new ImageView(MainActivity.this);
		image1.setImageResource(R.drawable.p1); 
		ImageView image2 = new ImageView(MainActivity.this);
		image2.setImageResource(R.drawable.p2);
		ImageView image3 = new ImageView(MainActivity.this);
		image3.setImageResource(R.drawable.p3);
		
		/*image1.setScaleType(ImageView.ScaleType.FIT_XY);
		image1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 
												LayoutParams.MATCH_PARENT));		
		image2.setScaleType(ImageView.ScaleType.FIT_XY);
		image2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 
												LayoutParams.MATCH_PARENT));
		image3.setScaleType(ImageView.ScaleType.FIT_XY);
		image3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 
												LayoutParams.MATCH_PARENT));*/
		
		flipper.addView(image1, 0);
		flipper.addView(image2, 1);
		flipper.addView(image3, 2);
		
		
	}
	
	public void prev(View v)
	{
		flipper.setInAnimation(this, android.R.anim.slide_in_left);
		flipper.setOutAnimation(this, android.R.anim.slide_out_right);
		
		flipper.showPrevious();
		
		flipper.stopFlipping();
	}
	
	public void next(View v)
	{
		flipper.setInAnimation(this, android.R.anim.slide_in_left);
		flipper.setOutAnimation(this, android.R.anim.slide_out_right);
		
		flipper.showNext();
		
		flipper.stopFlipping();
	}
	
	private int auotPlayCount = 0;
	
	public void autoPlay(View v)
	{
		if (auotPlayCount%2 == 0)
		{
			flipper.setInAnimation(this, android.R.anim.slide_in_left);
			flipper.setOutAnimation(this, android.R.anim.slide_out_right);
			
			flipper.startFlipping();
			
			auotPlayBtn.setText("stop play");
		}
		else
		{
			flipper.setInAnimation(this, android.R.anim.slide_in_left);
			flipper.setOutAnimation(this, android.R.anim.slide_out_right);
			
			flipper.stopFlipping();
			
			auotPlayBtn.setText("auto play");
		}
		auotPlayCount++;		
	}
	
}
