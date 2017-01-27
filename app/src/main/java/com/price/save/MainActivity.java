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

    private Button btn_phone_antisteal;
    private Button btn_communication;
    private Button btn_software;
    private Button btn_process;
    private Button btn_flow;
    private Button btn_antivirus;
    private Button btn_cache;
    private Button btn_advanced;
    private Button btn_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initView();
    }

//    private void initView() {
//        btn_phone_antisteal = (Button) findViewById(R.id.btn_phone_against_steal);
//        btn_communication = (Button) findViewById(R.id.btn_communication);
//        btn_software = (Button) findViewById(R.id.btn_software);
//        btn_process = (Button) findViewById(R.id.btn_process);
//        btn_flow = (Button) findViewById(R.id.btn_flow);
//        btn_antivirus = (Button) findViewById(R.id.btn_antivirus);
//        btn_cache = (Button) findViewById(R.id.btn_cache);
//        btn_advanced = (Button) findViewById(R.id.btn_advanced_tool);
//        btn_setting = (Button) findViewById(R.id.btn_setting);
//    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
//            case R.id.btn_phone_against_steal:
//                break;
//            case R.id.btn_communication:
//                break;
//            case R.id.btn_software:
//                break;
//            case R.id.btn_process:
//                break;
//            case R.id.btn_flow:
//                break;
//            case R.id.btn_antivirus:
//                break;
//            case R.id.btn_cache:
//                break;
//            case R.id.btn_advanced_tool:
//                break;
//            case R.id.btn_setting:
//                break;
        }
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
