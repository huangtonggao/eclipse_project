package com.example.alertdialogtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends Activity {
	
	private EditText show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		show = (EditText)findViewById(R.id.show);
	}
	private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder)
	{
		return builder.setPositiveButton("确认", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("确认键被按下");
				
			}
		});
	}
	
	private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder)
	{
		return builder.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("取消键被按下");;
				
			}
		});
	}
	
	//Button1的响应
	public void simple(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("简单对话框")
			.setIcon(R.drawable.ic_launcher)
			.setMessage("对话框的测试内容\n 第二行内容");
		
		setPositiveButton(builder);
		setNegativeButton(builder)
			.create()
			.show();
	}
	
	//Button2的响应
	private String[] items = new String[]{"西游记", "水浒传", "三国演义", "红楼梦"};
	public void simpleList(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("简单列表对话框")
			.setIcon(R.drawable.ic_launcher)
			.setItems(items, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					show.setText("你选中了---" + items[which]);
				}
			});
		
		/*setPositiveButton(builder); //简单列表中，点击items项后，对话框会自动消失，因此该处的确认和取消键没有多大作用
		setNegativeButton(builder)
			.create()
			.show();*/
		setNegativeButton(builder).
			create()
			.show();			
	}
	
	//Button3响应
	public void singleChoice(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("单选列表对话框")
			.setIcon(R.drawable.ic_launcher)
			.setSingleChoiceItems(items, 1, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					show.setText("你选中了--" + items[which]);
				}
			});
		
		setPositiveButton(builder);
		setNegativeButton(builder)
			.create()
			.show();
	}
	
	//Button4
	public void multiChoice(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("多选择项对话框")
			.setIcon(R.drawable.ic_launcher)
			.setMultiChoiceItems(items, /*new boolean[]{false, true, false, false}*/null, null);
		
		setPositiveButton(builder);
		setNegativeButton(builder)
			.create()
			.show();
	}
	
	//Button5
	public void customList(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("自定义对话框")
			.setIcon(R.drawable.ic_launcher)
			.setSingleChoiceItems(new ArrayAdapter<String>(this, R.layout.array_items, items), 0, null);
			/*.setAdapter(new ArrayAdapter<String>(this, R.layout.array_items, items), null);*/
		
		setPositiveButton(builder);
		setNegativeButton(builder)
			.create()
			.show();
	}
	
	//Button6
	public void customView(View v)
	{
		TableLayout loginView = (TableLayout)getLayoutInflater()
									.inflate(R.layout.login, null);
		
		new AlertDialog.Builder(this)
			.setTitle("自定义View对话框")
			.setIcon(R.drawable.ic_launcher)
			.setView(loginView)
			.setPositiveButton("登陆", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
			.setNegativeButton("取消", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
			.create()
			.show();
		
	}
	
	
	
}





















