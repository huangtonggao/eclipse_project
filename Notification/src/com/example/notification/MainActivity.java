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
		.setTicker("������Ϣ")
		.setSmallIcon(R.drawable.ic_launcher)
		.setDefaults(Notification.DEFAULT_ALL)
		.setContentTitle("һ����֪ͨ")
		.setContentText("��ϲ��������н�ˣ���������20%")
		.setWhen(System.currentTimeMillis())
		.setContentIntent(contentItent);
		 
		/@SuppressWarnings("deprecation")
		Notification notify = builder.getNotification();*/
     // ����Notification�ĸ�������   
        Notification notification =new Notification(R.drawable.ic_launcher,   
                "����ϵͳ", System.currentTimeMillis()); 
        //FLAG_AUTO_CANCEL   ��֪ͨ�ܱ�״̬���������ť�������
        //FLAG_NO_CLEAR      ��֪ͨ���ܱ�״̬���������ť�������
        //FLAG_ONGOING_EVENT ֪ͨ��������������
        //FLAG_INSISTENT     �Ƿ�һֱ���У���������һֱ���ţ�֪���û���Ӧ
        notification.flags |= Notification.FLAG_ONGOING_EVENT; // ����֪ͨ�ŵ�֪ͨ����"Ongoing"��"��������"����   
        notification.flags |= Notification.FLAG_NO_CLEAR; // �����ڵ����֪ͨ���е�"���֪ͨ"�󣬴�֪ͨ�������������FLAG_ONGOING_EVENTһ��ʹ��   
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;   
        //DEFAULT_ALL     ʹ������Ĭ��ֵ�������������𶯣������ȵ�
        //DEFAULT_LIGHTS  ʹ��Ĭ��������ʾ
        //DEFAULT_SOUNDS  ʹ��Ĭ����ʾ����
        //DEFAULT_VIBRATE ʹ��Ĭ���ֻ��𶯣������<uses-permission android:name="android.permission.VIBRATE" />Ȩ��
        notification.defaults = Notification.DEFAULT_ALL; 
        //����Ч������
        //notification.defaults=Notification.DEFAULT_LIGHTS|Notification.DEFAULT_SOUND;
        notification.ledARGB = Color.BLUE;   
        notification.ledOnMS =5000; //����ʱ�䣬����

          
        // ����֪ͨ���¼���Ϣ   
        CharSequence contentTitle ="����ϵͳ����"; // ֪ͨ������   
        CharSequence contentText ="����ϵͳ����"; // ֪ͨ������   
        notification.setLatestEventInfo(this, contentTitle, contentText, contentItent);   
          
        // ��Notification���ݸ�NotificationManager   
		nf.notify(0x123, notification);
		
	}
	
	public void delete(View v)
	{
		nf.cancel(0x123);
	}
}
