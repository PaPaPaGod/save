package com.price.save.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.price.save.ConstantValue;
import com.price.save.R;
import com.price.save.utils.SpUtils;
import com.price.save.view.SettingItemView;

/**
 * Created by price on 1/27/2017.
 */

public class SettingActivity extends Activity {
    private SettingItemView update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        update = (SettingItemView) findViewById(R.id.setting_update);
        update.setCheck(SpUtils.getBoolean(this, ConstantValue.OPEN_UPDATE,false));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = update.isCheck();
                Log.e("isCheck",isCheck+"");
                update.setCheck(!isCheck);
                SpUtils.spWriteBoolean(SettingActivity.this,ConstantValue.OPEN_UPDATE,!isCheck);
            }
        });
//        final CheckBox checkBox = (CheckBox) findViewById(R.id.cb_box);
//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isCheck = checkBox.isChecked();
//                checkBox.setChecked(!isCheck);
//            }
//        });
    }
}
