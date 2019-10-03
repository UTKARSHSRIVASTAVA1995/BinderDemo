package com.example.binderdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private final IBinder mBinder  = new LocalService();



    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    public class LocalService extends Binder{

        MyService getService()
        {
            return MyService.this;
        }

    }
    public static String getFirstMessage()
    {
        return "Hello";
    }
    public String getSecondMessage()
    {
        return "How are You";
    }

}
