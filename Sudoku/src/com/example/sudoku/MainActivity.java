package com.example.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View continueBtn = findViewById(R.id.continue_btn);
		continueBtn.setOnClickListener((OnClickListener) this);
		View newBtn = findViewById(R.id.new_btn);
		newBtn.setOnClickListener((OnClickListener) this);
		
		View exitBtn = findViewById(R.id.exit_btn);
		exitBtn.setOnClickListener((OnClickListener)this);
		
		View aboutBtn = findViewById(R.id.about_btn);
		aboutBtn.setOnClickListener((OnClickListener)this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.about_btn:
			{
				Intent i = new Intent(this, About.class);
				startActivity(i);
				break;
			}
			case R.id.new_btn:
			{
				openNewGameDialog();
				break;
			}
			case R.id.exit_btn:
			{
				finish();
				break;
			}
		
		
		}
		
	}
	
	private static final String TAG="sudoku";
	private void openNewGameDialog()
	{
		new AlertDialog.Builder(this)
			.setTitle(R.string.new_game_title)
			.setItems(R.array.diffculty, 
					new DialogInterface.OnClickListener() {						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							startGame(which);
						}
					})
					.show();
	}
	
	private void startGame(int i)
	{
		Log.d(TAG, "click on + " + i);
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case R.id.settings:
		{
			startActivity(new Intent(this, Prefs.class));
			return true;
		}
			

		
		case R.id.settings222:
		{
			startActivity(new Intent(this, About.class));
			return true;
		}
		
		default:
		{
			return false;
		}
			
		
	
		}
	}
}

















