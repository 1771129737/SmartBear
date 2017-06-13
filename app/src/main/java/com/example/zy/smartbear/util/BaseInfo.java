package com.example.zy.smartbear.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import static android.R.attr.width;

/**
 * Created by ZhangYin on 2017/6/13.
 */

public class BaseInfo {

    private final static String TAG = "BaseInfo";

    private int phoneWidth = 0;//屏幕宽 像素
    private int phoneHeight = 0;//屏幕高 像素
    private int actionBarWidth = 0;//状态栏 宽
    private int ctionBarHeight = 0;//状态栏 高


    public BaseInfo() {

    }


    public void init(Context context) {
        //获取屏幕宽高
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        phoneWidth = metrics.widthPixels;
        phoneHeight = metrics.heightPixels;



    }



}
