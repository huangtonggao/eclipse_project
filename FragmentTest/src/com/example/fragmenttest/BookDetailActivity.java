package com.example.fragmenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class BookDetailActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		if (savedInstanceState == null)
		{
			BookDetailFragment fragment = new BookDetailFragment();
			
			Bundle arguments = new Bundle();
			arguments.putInt("item_id", getIntent().getIntExtra("item_id", 0));
			
			fragment.setArguments(arguments);
			
			getFragmentManager().beginTransaction()
					.add(R.id.book_detail_container, fragment).commit();
		}
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home)
		{
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(intent);
			
			return true;
		}
				
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	
	

}
