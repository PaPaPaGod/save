package com.price.save.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * 自定义的跑马灯TextView
 * Created by price on 1/26/2017.
 */

public class MarqueeTextView extends TextView {
    //通过Java代码创建时使用
    public MarqueeTextView(Context context) {
        super(context);
    }

    //重写获取焦点的方法
    @Override
    public boolean isFocused() {
        return true;
    }

    //在布局文件创建时使用，由系统调用，带属性
    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //在布局文件创建时使用，由系统调用，带属性+布局文件样式
    public MarqueeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MarqueeTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
