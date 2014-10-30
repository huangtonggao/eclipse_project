package com.example.calendarview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CalendarView cv = (CalendarView)findViewById(R.id.calendarView);
		
		cv.setOnDateChangeListener(new OnDateChangeListener() {
			
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "你生日是" + year + "年" + month + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
				
			}
		});
	}
}
