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
		return builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("ȷ�ϼ�������");
				
			}
		});
	}
	
	private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder)
	{
		return builder.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("ȡ����������");;
				
			}
		});
	}
	
	//Button1����Ӧ
	public void simple(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("�򵥶Ի���")
			.setIcon(R.drawable.ic_launcher)
			.setMessage("�Ի���Ĳ�������\n �ڶ�������");
		
		setPositiveButton(builder);
		setNegativeButton(builder)
			.create()
			.show();
	}
	
	//Button2����Ӧ
	private String[] items = new String[]{"���μ�", "ˮ䰴�", "��������", "��¥��"};
	public void simpleList(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("���б�Ի���")
			.setIcon(R.drawable.ic_launcher)
			.setItems(items, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					show.setText("��ѡ����---" + items[which]);
				}
			});
		
		/*setPositiveButton(builder); //���б��У����items��󣬶Ի�����Զ���ʧ����˸ô���ȷ�Ϻ�ȡ����û�ж������
		setNegativeButton(builder)
			.create()
			.show();*/
		setNegativeButton(builder).
			create()
			.show();			
	}
	
	//Button3��Ӧ
	public void singleChoice(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("��ѡ�б�Ի���")
			.setIcon(R.drawable.ic_launcher)
			.setSingleChoiceItems(items, 1, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					show.setText("��ѡ����--" + items[which]);
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
			.setTitle("��ѡ����Ի���")
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
			.setTitle("�Զ���Ի���")
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
			.setTitle("�Զ���View�Ի���")
			.setIcon(R.drawable.ic_launcher)
			.setView(loginView)
			.setPositiveButton("��½", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
			.setNegativeButton("ȡ��", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
			.create()
			.show();
		
	}
	
	
	
}





















