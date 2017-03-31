package com.example.servicetest;

//import android.app.Notification;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {
	private DownloadBinder mBinder = new DownloadBinder();
	class DownloadBinder extends Binder{
		public void startDownload(){
		Log.d("MyService", "startDownload executed");
	}
	public int getProgress(){
		Log.d("MyService", "getProgress executed");
		return 0;
	}
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}

	@SuppressLint("NewApi")
	@Override
	public void onCreate(){
		super.onCreate();
		Notification.Builder builder = new Notification.Builder(this);
		builder.setContentTitle("Some title").setContentText("This is content")
		            .setSmallIcon(R.drawable.ic_launcher);
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		builder.setLargeIcon(bm);
		Notification notification = builder.build();
		
		/*
		Notification notification= new Notification(R.drawable.ic_launcher,
				"Notification comes",System.currentTimeMillis());
		Intent notificationonIntent = new Intent(this,MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationonIntent, 0);
		notification.setLatestEventInfo(this,"This is tittle","This is content",pendingIntent);
		startForeground(1, notification);
		*/
		
		
		Log.d("MyService", "onCreate execute");
	}
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		Log.d("MyService", "onStartCommand execute");
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.d("MyService", "onDestroy execute");
	}
}
