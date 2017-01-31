package com.price.save.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.price.save.R;

/**
 * Created by price on 1/27/2017.
 */

public class SettingItemView extends RelativeLayout implements CompoundButton.OnCheckedChangeListener {

    private TextView tv_title;
    private TextView tv_desc;
    private CheckBox cb_update;

    public SettingItemView(Context context) {
        this(context,null);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);

    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        View.inflate(context, R.layout.item_setting,this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_desc = (TextView) findViewById(R.id.tv_desc);
        cb_update = (CheckBox) findViewById(R.id.cb_update);
        cb_update.setOnCheckedChangeListener(this);
    }

    public boolean isCheck(){
        return cb_update.isChecked();
    }

    public void setCheck(boolean isChecked){
        cb_update.setChecked(isChecked);
        Log.e("check",cb_update.isChecked()+"::"+isChecked);
        if(isChecked){
            tv_desc.setText("自动更新已开启");
        }else{
            tv_desc.setText("自动更新已关闭");
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            tv_desc.setText("自动更新已开启");
        }else{
            tv_desc.setText("自动更新已关闭");
        }
    }
}
