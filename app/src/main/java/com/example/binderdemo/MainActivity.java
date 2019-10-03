package com.example.binderdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    MyService myService;
    boolean isbind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.tv1);
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    public void getFirstservicemessage(View view) {

        String message;
        message = MyService.getFirstMessage();
        textview.setText(message);


    }

    public void getSecondservicemessage(View view) {
        String message;
        message = MyService.getFirstMessage();
        textview.setText(message);

    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            MyService.LocalService localservice = (MyService.LocalService) iBinder;
            myService = localservice.getService();
            isbind = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbind = false;

        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if(isbind);
        {
            unbindService(mConnection);
            isbind = false;
        }
    }
}


