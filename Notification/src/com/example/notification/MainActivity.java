package com.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private NotificationManager nf;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nf = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	
	public void send(View v)
	{
		
		Intent notificationIntent =new Intent(MainActivity.this, otherActivity.class); 
        PendingIntent contentItent = PendingIntent.getActivity(this, 0, notificationIntent, 0);  
		
        /*Notification.Builder builder = new Notification.Builder(MainActivity.this)
		.setAutoCancel(true)
		.setTicker("有新消息")
		.setSmallIcon(R.drawable.ic_launcher)
		.setDefaults(Notification.DEFAULT_ALL)
		.setContentTitle("一条新通知")
		.setContentText("恭喜您，您加薪了，工资增加20%")
		.setWhen(System.currentTimeMillis())
		.setContentIntent(contentItent);
		 
		/@SuppressWarnings("deprecation")
		Notification notify = builder.getNotification();*/
     // 定义Notification的各种属性   
        Notification notification =new Notification(R.drawable.ic_launcher,   
                "督导系统", System.currentTimeMillis()); 
        //FLAG_AUTO_CANCEL   该通知能被状态栏的清除按钮给清除掉
        //FLAG_NO_CLEAR      该通知不能被状态栏的清除按钮给清除掉
        //FLAG_ONGOING_EVENT 通知放置在正在运行
        //FLAG_INSISTENT     是否一直进行，比如音乐一直播放，知道用户响应
        notification.flags |= Notification.FLAG_ONGOING_EVENT; // 将此通知放到通知栏的"Ongoing"即"正在运行"组中   
        notification.flags |= Notification.FLAG_NO_CLEAR; // 表明在点击了通知栏中的"清除通知"后，此通知不清除，经常与FLAG_ONGOING_EVENT一起使用   
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;   
        //DEFAULT_ALL     使用所有默认值，比如声音，震动，闪屏等等
        //DEFAULT_LIGHTS  使用默认闪光提示
        //DEFAULT_SOUNDS  使用默认提示声音
        //DEFAULT_VIBRATE 使用默认手机震动，需加上<uses-permission android:name="android.permission.VIBRATE" />权限
        notification.defaults = Notification.DEFAULT_ALL; 
        //叠加效果常量
        //notification.defaults=Notification.DEFAULT_LIGHTS|Notification.DEFAULT_SOUND;
        notification.ledARGB = Color.BLUE;   
        notification.ledOnMS =5000; //闪光时间，毫秒

          
        // 设置通知的事件消息   
        CharSequence contentTitle ="督导系统标题"; // 通知栏标题   
        CharSequence contentText ="督导系统内容"; // 通知栏内容   
        notification.setLatestEventInfo(this, contentTitle, contentText, contentItent);   
          
        // 把Notification传递给NotificationManager   
		nf.notify(0x123, notification);
		
	}
	
	public void delete(View v)
	{
		nf.cancel(0x123);
	}
}
