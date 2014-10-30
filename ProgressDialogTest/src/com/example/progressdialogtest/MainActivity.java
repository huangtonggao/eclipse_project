package com.example.progressdialogtest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
	
	private final static int MAX_PROGRESS = 100;
	
	private int progressStatus = 0;
	
	ProgressDialog pd1, pd2;
	
	Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg) {
			
			if (msg.what == 0x123)
			{
				Log.i("MSG", "" + msg.what + "progressStatus is " + progressStatus);
				pd2.setProgress(progressStatus);
			}
	    }
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void showSpinner(View v)
	{
		ProgressDialog.show(this, "Task is running", "Task running, please waiting",
					 		false, true);
	}
	
	public void showIndeterminate(View v)
	{
		pd1 = new ProgressDialog(MainActivity.this);
		
		pd1.setTitle("Task is running");
		
		pd1.setMessage("Please wating");
		
		pd1.setCancelable(true);
		
		pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		
		pd1.setIndeterminate(false);
		
		pd1.setMax(123);
		
		pd1.show();
		
		pd1.setProgress(10);
		
	}
	
	public void showProgress(View v)
	{
		progressStatus = 0;
		
		pd2 = new ProgressDialog(this);
		
		pd2.setMax(MAX_PROGRESS);
		
		pd2.setTitle("完成百分比");
		
		pd2.setMessage("耗时任务完成的百分比");
		
		pd2.setCancelable(false);
		
		pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		
		pd2.setIndeterminate(false);
		
		pd2.show();
		
		new Thread()
		{
			public void run()
			{
				while (progressStatus < MAX_PROGRESS)
				{
					progressStatus++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					handler.sendEmptyMessage(0x123);
				}
				if (progressStatus >= MAX_PROGRESS)
				{
					pd2.dismiss(); //关闭对话框
				}
			}
		}.start();
		
	}
}







