package com.example.zy.smartbear;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        Logs.i(TAG, "info:" +
                "", sharedP.get("name", "default"), sharedP.get("age", 1), sharedP.get("sex", true), sharedP.get("he", 2.2f), sharedP.get("we", 2147483647));
    }
}
