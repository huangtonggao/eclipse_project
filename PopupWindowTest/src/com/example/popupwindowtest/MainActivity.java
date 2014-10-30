package com.example.popupwindowtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout popupView = (LinearLayout)getLayoutInflater()
									.inflate(R.layout.popupview, null);
		
		final PopupWindow popup = new PopupWindow(popupView, 280, 260);
		
		((Button)findViewById(R.id.click)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub		
				popup.showAsDropDown(v);
				popup.setFocusable(true);
				//popup.showAtLocation( findViewById(R.id.click), Gravity.CENTER, 100, 100);			
			}
		});
		
		((Button)popupView.findViewById(R.id.button1_sure)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup.dismiss();
				
			}
		});
		((Button)popupView.findViewById(R.id.button2_cancel)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup.dismiss();
				
			}
		});
	}
}
