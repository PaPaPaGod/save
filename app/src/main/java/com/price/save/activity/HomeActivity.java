package com.price.save.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.price.save.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by price on 2017/1/6.
 */
public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView recyclerView;
    private GridView gv_home;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(500);
        RelativeLayout rl_activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        rl_activity_main.setAnimation(animation);
        initView();
    }

    private void initView() {
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerView.set
        gv_home = (GridView) findViewById(R.id.gv_home);
        initData();
        gv_home.setAdapter(new MyAdapter(mData,this));
        gv_home.setOnItemClickListener(this);
    }

    private void initData() {
        String[] data = new String[]{
                "通信卫士",
                "软件管理",
                "手机防盗",
                "手机杀毒",
                "进程管理",
                "流量管理",
                "缓存管理",
                "高级工具",
                "设置中心",
        };
        mData = Arrays.asList(data);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this,AntiStealActivity.class));
                break;
            case 8:
                startActivity(new Intent(this,SettingActivity.class));
                break;
        }
    }
}
