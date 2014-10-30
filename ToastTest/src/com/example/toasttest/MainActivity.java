package com.example.toasttest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button simple, picture;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		simple = (Button)findViewById(R.id.showSimple);
		picture = (Button)findViewById(R.id.showPicture);
		
		simple.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast toast = Toast.makeText(MainActivity.this, "简单的提示信息", Toast.LENGTH_SHORT);
				
				toast.show();				
			}
		});
		
		picture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView image = new ImageView(MainActivity.this);
				image.setImageResource(R.drawable.ic_launcher);
				
				TextView textView = new TextView(MainActivity.this);
				textView.setText("带图片的提示");
				textView.setTextSize(20);
				textView.setTextColor(Color.RED);
				
				LinearLayout ll = new LinearLayout(MainActivity.this);
				ll.addView(image);
				ll.addView(textView);
				
				Toast toast = new Toast(MainActivity.this);
				toast.setGravity(Gravity.CENTER, 0, 0);
				
				toast.setView(ll);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.show();
				
			}
		});
		
	}
}
