package com.example.numberpicker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class MainActivity extends Activity {

	private NumberPicker np;
	private EditText editText;
	private int curVal;
	private int oldVal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		np = (NumberPicker)findViewById(R.id.np1);
		editText = (EditText)findViewById(R.id.editText);
		np.setMinValue(0);
		np.setMaxValue(100);
		
		np.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				// TODO Auto-generated method stub
				MainActivity.this.curVal = newVal;
				MainActivity.this.oldVal = oldVal;
				
				showDate(newVal, oldVal);
			}
		});
		
		
	}
	
	private void showDate(int newVal, int oldVal)
	{
		editText.setText("newVal is " + newVal + " " + "oldVal is " + oldVal);
	}
}
