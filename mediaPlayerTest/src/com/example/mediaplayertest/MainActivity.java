package com.example.mediaplayertest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private MediaPlayer mediaPlayer;  
	
	Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg) {
			if (mediaPlayer.isPlaying())
			{
				mediaPlayer.stop();
			}
			if (msg.what == 0)
			{
				mediaPlayer.reset();
				
				AssetFileDescriptor input = getResources().openRawResourceFd(R.raw.m1);
				
				try {
					mediaPlayer.setDataSource(input.getFileDescriptor());
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//mediaPlayer.setAudioStreamType(AudioManager.ADJUST_SAME);
				try {
					mediaPlayer.prepare();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Log.i("Test", ""+mediaPlayer.isLooping());
				
				mediaPlayer.start();
				mediaPlayer.setLooping(false);
				
				try {
					Thread.sleep(1600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				mediaPlayer.stop();
				 //mediaPlayer.stop();
				Log.i("Test", "hello");
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 mediaPlayer = new MediaPlayer();  
		 //mediaPlayer.setOnCompletionListener(this);
		
		
	     ButtonClickListener listener = new ButtonClickListener();
	     
	     Button btn1 = (Button)findViewById(R.id.btn1);
	     
	     btn1.setOnClickListener(listener);
	     
	}
	
	
	private final class ButtonClickListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button btn = (Button)v;

    		switch (btn.getId())
			{
				case R.id.btn1:
				{
					try {
						play();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			
		}
		
		private void play() throws IOException
		{			
			new Thread(){
				@Override
				public void run()
				{
					handler.sendEmptyMessage(0);
					Log.i("Test", "out of thread");
				}
			}.start();
			
			Log.i("Test", "out of play");
			
			
			
			//AssetManager am = getAssets(); 
			
			//InputStream input = am.open("m1.mp3");
//			String[] names = am.list("");//获取assets目录
//		
//			for (int i = 0; i < names.length; i++)
//			{
//				Log.i("Test", names[i]);
//			}
			
			
			//FileInputStream file = new FileInputStream("assets/m1.mp3");
			//InputStream file = am.open("m1.mp3");
//	        mediaPlayer.reset();  //重置为初始状态  
//	        mediaPlayer.setDataSource("assets/m1.mp3");  
//	        mediaPlayer.prepareAsync();  
//	        mediaPlayer.start();//播放  
			
			//File file = new File("assets/m1.mp3");
			//FileInputStream f = new FileInputStream("assets/m1.mp3");

		}

		
		
	}
	
	
}


