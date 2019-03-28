package com.example.ma18services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("!!!", "onstartCommand: start");
        Log.d("!!!", "thread: " + Thread.currentThread().getName() );

        MyAsyncTask task = new MyAsyncTask();
        task.execute();


//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Log.d("!!!", "onstartCommand: finished");


        return START_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("!!!", "Ondestroy");
    }


}

class MyAsyncTask extends AsyncTask<Integer, String, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.d("!!!", "OnpreExecute, Thread: " + Thread.currentThread().getName());
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        Log.d("!!!", "doInbackground, Thread: " + Thread.currentThread().getName());

        for (int i = 1; i <= 10; i++) {
           // Log.d("!!!", "Counter: " + String.valueOf(i));
            publishProgress("Counter is: " + String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

        Log.d("!!!" , "onprogressupdate " + values[0] + "Thread: " + Thread.currentThread().getName());


    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.d("!!!", "OnPostExecute, Thread: " + Thread.currentThread().getName());


    }
}
