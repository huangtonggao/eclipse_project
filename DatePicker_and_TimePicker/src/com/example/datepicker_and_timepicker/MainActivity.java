package com.example.datepicker_and_timepicker;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = (EditText)findViewById(R.id.editText);
		DatePicker date = (DatePicker)findViewById(R.id.datePicker);
		TimePicker time = (TimePicker)findViewById(R.id.timePicker);
		
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
		
		showDate(year, month, day, hour, minute);
		
		date.init(year, month, day, new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				MainActivity.this.year = year;
				MainActivity.this.month = monthOfYear;
				MainActivity.this.day = dayOfMonth;
				
				showDate(year, month, day, hour, minute);
				
			}
		});		
		
		time.setIs24HourView(true);
		time.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				MainActivity.this.hour = hourOfDay;
				MainActivity.this.minute = minute;
				
				showDate(MainActivity.this.year, MainActivity.this.month, MainActivity.this.day, hourOfDay, minute);
				
			}
		});
		
		
		
	}
	
	private void showDate(int year, int month, int day, int hour, int minute)
	{
	
		editText.setText(year + "." + month + "." + day + " " + hour + ":" + minute );
	}
	
	
	
	
}
