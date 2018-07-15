package com.example.wangtao.project_jingdong.mvp.mainpage.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wangtao.project_jingdong.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
   private Handler handler=new Handler(){@Override public void handleMessage(Message msg) { super.handleMessage(msg); }};
   private int i=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         initView();
    }

    private void initView() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                  i--;
                  if (i == 0){
                      Intent intent=new Intent(MainActivity.this,ShowActivity.class);
                      startActivity(intent);
                      timer.cancel();
                  }
            }
        },1000,1000);
    }
}
