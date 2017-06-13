package com.example.zy.smartbear;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.zy.smartbear.util.BaseInfo;
import com.example.zy.smartbear.util.Logs;
import com.example.zy.smartbear.util.SharedP;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedP sharedP = new SharedP(this, "sp", Context.MODE_PRIVATE);
//        sharedP.set("name", "zy1").set("age", 181).set("sex", false).set("he", 164.51f).set("we", 1200001);
//        sharedP.clear();
//        Logs.i(TAG, "info:" +
//                "", sharedP.get("name", "default"), sharedP.get("age", 1), sharedP.get("sex", true), sharedP.get("he", 2.2f), sharedP.get("we", 2147483647));

        BaseInfo info = new BaseInfo();
        info.init(this);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int w = 0;
        int h = 0;
        if(hasFocus == true){
            Rect outRect = new Rect();
            this.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
//             outRect.top;//状态栏高度
        }
        Logs.i(TAG,"hasFocus:",hasFocus,w,h);
    }
}
