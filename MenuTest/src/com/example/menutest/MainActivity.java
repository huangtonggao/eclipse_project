package com.example.menutest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText edit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edit = (EditText)findViewById(R.id.editText);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		SubMenu fontMenu = menu.addSubMenu("�����С");
		fontMenu.setIcon(R.drawable.ic_launcher);
		fontMenu.setHeaderIcon(R.drawable.ic_launcher);
		fontMenu.setHeaderTitle("ѡ�������С");
		
		fontMenu.add(0, 0x111, SubMenu.NONE, "10������");
		fontMenu.add(0, 0x222, 0, "12������");
		fontMenu.add(0, 0x333, 0, "14������");
		fontMenu.add(0, 0x444, 0, "16������");
		fontMenu.add(0, 0x555, 0, "18������");
		
		menu.add(0, 0x11b, 0,"��ͨ�˵���");
		
		SubMenu colorMenu = menu.addSubMenu("font color");
		colorMenu.setIcon(R.drawable.ic_launcher);
		colorMenu.setHeaderIcon(R.drawable.ic_launcher);
		colorMenu.setHeaderTitle("Please choose font color");
		
		colorMenu.add(0, 0x116, 0, "red");
		colorMenu.add(0,0x117,0,"green");
		colorMenu.add(0, 0x118,0,"blue");		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem ml)
	{
		switch(ml.getItemId())
		{
			case 0x111:
			{
				edit.setTextSize(10*2);
				break;
			}
			case 0x222:
			{
				edit.setTextSize(12*2);
				break;
			}
			case 0x333:
			{
				edit.setTextSize(14*2);
				break;
			}
			case 0x444:
			{
				edit.setTextSize(16*2);
				break;
			}
			case 0x555:
			{
				edit.setTextSize(18*2);
				break;
			}
			case 0x116:
			{
				edit.setTextColor(Color.RED);
				break;
			}
			case 0x117:
			{
				edit.setTextColor(Color.GREEN);
				break;
			}
			case 0x118:
			{
				edit.setTextColor(Color.BLUE);
				break;
			}
			
		}
		
		
		return true;
	}
}
