package com.price.save;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView clock;
    Button stop;
    boolean run = true;
    private int i;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    clock.setText(R.string.text_time+""+msg.obj);
                    break;
                case 101:
                    run = false;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clock = (TextView) findViewById(R.id.tv_clock);
        stop = (Button) findViewById(R.id.btn_stop);
        stop.setOnClickListener(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(run){
                    i++;
                    Message msg = Message.obtain();
                    msg.what = 100;
                    msg.obj = i;
                    handler.sendMessage(msg);
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        moveTaskToBack(false);
//    }

    @Override
    public void onClick(View view) {
        Message msg = Message.obtain();
        msg.what = 101;
        handler.sendMessage(msg);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
