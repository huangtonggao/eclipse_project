package com.example.listactivitytest;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] array = new String[]{"Jordan", "Jack", "Chester"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
																android.R.layout.simple_list_item_multiple_choice,
																array);
		setListAdapter(adapter);

	}
}
