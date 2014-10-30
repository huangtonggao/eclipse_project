package com.example.soundpooltest;

import java.util.HashMap;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button btn1;
	Button btn2;
	
	SoundPool soundPool;
	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn1 = (Button)findViewById(R.id.btn1);
		
		// 设置最多可容纳10个音频流,音频的品质为5  
        soundPool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);  
        
        hashMap.put(1, soundPool.load(this, R.raw.m1, 1));
        hashMap.put(1, soundPool.load(this, R.raw.m2, 1));
        hashMap.put(1, soundPool.load(this, R.raw.m3, 1));
        
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				soundPool.play(hashMap.get(1), 1, 1, 0, 5, 1);
				
			}
		});
        
        
        
        
	}
}
