package com.example.contextmenutest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView txt;
	
	private final int MENU1 = 0x111;
	private final int MENU2 = 0x222;
	private final int MENU3 = 0x333;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txt = (TextView)findViewById(R.id.textView);
		
		registerForContextMenu(txt);	
		
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu,
            View v,
            ContextMenu.ContextMenuInfo menuInfo)
	{
		menu.add(0, MENU1, 0, "红色");
		menu.add(0, MENU2, 0, "绿色");
		menu.add(0, MENU3, 0, "蓝色");
		
		//将三个菜单项色孩子为单选菜单项
		menu.setGroupCheckable(0, true, true);
		//设置上下文菜单的标题、图标
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.setHeaderTitle("选择背景颜色");
			
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case MENU1:
			{
				item.setCheckable(true);
				txt.setBackgroundColor(Color.RED);
				break;
			}
			case MENU2:
			{
				item.setCheckable(true);
				txt.setBackgroundColor(Color.GREEN);
				break;
			}
			case MENU3:
			{
				item.setCheckable(true);
				txt.setBackgroundColor(Color.BLUE);
				break;
			}
			
		}
		
		return true;
	}
	
	
	
	
	
}
