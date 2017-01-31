package com.price.save.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by price on 1/28/2017.
 */

public class SpUtils {
    private static SharedPreferences sharedPreferences;

    public static boolean getBoolean(Context context,String key,boolean value){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(key,value);
    }

    public static void spWriteBoolean(Context context,String key,boolean value){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putBoolean(key,value).commit();
    }
}
