package com.example.ma18services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyWorkerThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("!!!", "oncreate: " + Thread.currentThread().getName());
    }

    @Override
    protected void onHandleIntent( @Nullable Intent intent) {

        Log.d("!!!", "onHandle: " + Thread.currentThread().getName());

        for(int i = 1; i <= 10; i++) {
            Log.d("!!!", "counter is: " + i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("!!!" ,"onDestroy: " + Thread.currentThread().getName());
    }
}
