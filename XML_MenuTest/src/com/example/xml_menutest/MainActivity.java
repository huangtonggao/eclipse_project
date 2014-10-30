package com.example.xml_menutest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView)findViewById(R.id.textView);
		registerForContextMenu(textView);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.my_menu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		MenuInflater infalter = new MenuInflater(this);
		infalter.inflate(R.menu.contextmenu, menu);
		
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.setHeaderTitle("请选择背景颜色");
		
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.isCheckable())
		{
			item.setChecked(true);	
		}	
		
		switch(item.getItemId())
		{
			case R.id.red:
			{
				textView.setBackgroundColor(Color.RED);
				break;
			}
			case R.id.green:
			{
				textView.setBackgroundColor(Color.GREEN);
				break;
			}
			case R.id.blue:
			{
				textView.setBackgroundColor(Color.BLUE);
				break;
			}
		}		
		
		return super.onContextItemSelected(item);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.isCheckable())
		{
			item.setChecked(true);
		}
		switch (item.getItemId()) {
		case R.id.font_10:
		{
			textView.setTextSize(10*2);
			break;
		}			
		case R.id.font_12:
		{
			textView.setTextSize(12*2);
			break;
		}		
		case R.id.font_14:
		{
			textView.setTextSize(14*2);
			break;
		}
		case R.id.red_font:
		{
			textView.setTextColor(Color.RED);
			//item.setChecked(true);
			break;
		}
		case R.id.green_font:
		{
			textView.setTextColor(Color.GREEN);
			//item.setChecked(true);
			break;
		}
		case R.id.blue_font:
		{
			textView.setTextColor(Color.BLUE);
			//item.setChecked(true);
			break;
		}		
		case R.id.plain_item:
		{
			Toast.makeText(MainActivity.this, "您单击了普通菜单项", Toast.LENGTH_LONG).
						show();
			break;
		}

		default:
			break;
		}
		
		
		
		return super.onOptionsItemSelected(item);
	}
	
	private PopupMenu pop;
	public void onPopupClick(View v)
	{
		pop = new PopupMenu(this, v);
		getMenuInflater().inflate(R.menu.contextmenu, pop.getMenu());
		
		pop.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				
				switch (item.getItemId()) {
				case R.id.red:
				{
					item.setChecked(true);
					Toast.makeText(MainActivity.this, "红色", Toast.LENGTH_SHORT).show();
					break;
				}
				case R.id.green:
				{
					item.setChecked(true);
					Toast.makeText(MainActivity.this, "绿色", Toast.LENGTH_SHORT).show();
					break;
				}
				case R.id.blue:
				{
					item.setChecked(true);
					Toast.makeText(MainActivity.this, "蓝色", Toast.LENGTH_SHORT).show();
					break;
				}
					
					

				default:
					break;
				}
				
				return false;
			}
		});
		
		pop.show();
		
	}
	
	
	
	
	
	
	
}
