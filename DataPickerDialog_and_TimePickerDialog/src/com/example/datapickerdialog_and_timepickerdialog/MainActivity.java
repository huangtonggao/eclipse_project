package com.example.datapickerdialog_and_timepickerdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	
	private Button dataBtn, timeBtn;
	private EditText show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dataBtn = (Button)findViewById(R.id.dataBtn);
		timeBtn = (Button)findViewById(R.id.timeBtn);
		show = (EditText)findViewById(R.id.show);
		
		dataBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();
				
				new DatePickerDialog(MainActivity.this,
						new OnDateSetListener() {
							
							@Override
							public void onDateSet(DatePicker view, int year, int monthOfYear,
									int dayOfMonth) {
								// TODO Auto-generated method stub
								show.setText(year + " " + (monthOfYear+1) + " " + dayOfMonth);
								
							}
						},
						c.get(Calendar.YEAR),
						c.get(Calendar.MONTH),
						c.get(Calendar.DAY_OF_MONTH)).show();
				
				
			}
		});
		
		timeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();
				
				new TimePickerDialog(MainActivity.this, new OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						// TODO Auto-generated method stub
						show.setText(hourOfDay + " " + minute);
						
					}
				}, c.get(Calendar.HOUR_OF_DAY), 
				c.get(Calendar.MINUTE), true)
				.show();
				
			}
		});
		
	}
}
