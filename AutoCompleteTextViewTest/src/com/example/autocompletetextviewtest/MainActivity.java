package com.example.autocompletetextviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {

	AutoCompleteTextView auto;
	MultiAutoCompleteTextView mauto;
	
	String[] books = new String[]{
			"Jordan",
			"Jackson",
			"Chester"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books);
		
		auto = (AutoCompleteTextView)findViewById(R.id.auto);
		auto.setAdapter(adapter);
		
		mauto = (MultiAutoCompleteTextView)findViewById(R.id.mauto);
		mauto.setAdapter(adapter);
		
		mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}
