package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.i("Test", "MainActivity start");
		
		
	}
	
	public void launcher(View v)
	{
		/*�����Լ�*/
//		Intent intent = new Intent(MainActivity.this, MainActivity.class);
//		startActivity(intent);
		
		/*����SecondActivity.class*/
		Intent intent = new Intent();
		intent.setAction("com.example.intenttest.ACTION1");
//		
//		intent.addCategory("com.example.intenttest.category.HTG_CATEGORY2");
//		intent.addCategory("com.example.intenttest.category.HTG_CATEGORY3");
//		intent.addCategory("com.example.intenttest.category.HTG_CATEGORY1");
//		intent.addCategory("com.example.intenttest.category.HTG_CATEGORY4");
		
		//�����������
//		Intent intent = new Intent();
//		intent.setAction(Intent.ACTION_DIAL);  //�ò�������Ҫ��manifest������uses-permission
		
		//���������
//		Intent intent = new Intent();
//		intent.setAction(Intent.ACTION_VIEW); //����Ҫ��manifest������ uses-permission
//		intent.setData(Uri.parse("http://www.baidu.com.cn"));
		
		//data mimeType����SecondActivity
		//Intent intent = new Intent();
		//intent.setType("abcddd/123");
		
		//Data����SecondActivity
	    //intent.setData(Uri.parse("htg_test://www.sina.com:8000/com.test.mypath"));

		//manifest�У�Data��Type��ָ���ˣ���Intent�����ƥ��Data��Type
//		Intent intent = new Intent();
		intent.setDataAndType(Uri.parse("htg_test:/arbitary.com"), "abcddd/123");
		
		
		
		startActivity(intent);
	}
}
