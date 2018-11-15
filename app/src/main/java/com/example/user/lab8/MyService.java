package com.example.user.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public void onCreate(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);

                    Intent intent = new Intent(MyService.this,Main2Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyService.this.startActivity(intent);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
    public  int onStartCommand(Intent intent,int flags,int startId){
        super.onStartCommand(intent,flags,startId);
        return START_STICKY;
    }
}
