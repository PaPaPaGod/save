package com.price.save.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

import com.price.save.R;

/**
 * Created by price on 2016/12/8.
 */

public class SplashActivity extends AppCompatActivity {

    private static final int UPDATE = 101;
    private static final int ENTER_HOME = 100;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE:
                    break;
                case ENTER_HOME:
                    enterHome();
                    break;
            }
        }
    };

    private void enterHome() {
        startActivity(new Intent(this,HomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getVersionCode();
        AlphaAnimation animator = new AlphaAnimation(0,1);
        animator.setDuration(2000);
        RelativeLayout rl_splash = (RelativeLayout) findViewById(R.id.rl_splash);
        rl_splash.startAnimation(animator);
    }


    private void getVersionCode() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo(getPackageName(),0);
            int code = info.versionCode;
            mHandler.sendEmptyMessageDelayed(ENTER_HOME,2000);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
