package com.example.zy.smartbear.util;

import android.util.Log;

/**
 * Created by ZhangYin on 2017/6/12.
 */

public class Logs {
    public static String TAG = "MY-log";
    public static boolean debug = true;
    public static String space = " ";
    public static String hint = "(接上一条log)";
    private static final int LENGTH = 4 * 1024 - 200;
    private static final int E = 0x1;
    private static final int W = 0x2;
    private static final int I = 0x3;
    private static final int D = 0x4;
    private static final int V = 0x5;


    public static void setDebug(boolean debug) {
        Logs.debug = debug;
    }


    public static void e(String className, Object... logs) {
        StringBuilder builder = new StringBuilder(className).append(":");
        for (Object string : logs) {
            builder.append(string).append(space);
        }
        showLog(builder, E);
    }

    public static void w(String className, Object... logs) {
        if (debug) {
            StringBuilder builder = new StringBuilder(className).append(":");
            for (Object string : logs) {
                builder.append(string).append(space);
            }
            showLog(builder, W);
        }
    }

    public static void i(String className, Object... logs) {
        if (debug) {
            StringBuilder builder = new StringBuilder(className).append(":");
            for (Object string : logs) {
                builder.append(string).append(space);
            }
            showLog(builder, I);
        }
    }

    public static void d(String className, Object... logs) {
        if (debug) {
            StringBuilder builder = new StringBuilder(className).append(":");
            for (Object string : logs) {
                builder.append(string).append(space);
            }
            showLog(builder, D);
        }
    }

    public static void v(String className, Object... logs) {
        if (debug) {
            StringBuilder builder = new StringBuilder(className).append(":");
            for (Object string : logs) {
                builder.append(string).append(space);
            }
            showLog(builder, V);
        }
    }


    private static void showLog(StringBuilder builder, int type) {
        if (builder.length() < LENGTH) {
            switch (type) {
                case E:
                    Log.e(TAG, builder.toString());
                    break;
                case W:
                    Log.w(TAG, builder.toString());
                    break;
                case I:
                    Log.i(TAG, builder.toString());
                    break;
                case D:
                    Log.d(TAG, builder.toString());
                    break;
                case V:
                    Log.v(TAG, builder.toString());
                    break;
                default:
                    Log.i(TAG, builder.toString());
                    break;
            }
        } else {
            switch (type) {
                case E:
                    Log.e(TAG, builder.substring(0, LENGTH));
                    break;
                case W:
                    Log.w(TAG, builder.substring(0, LENGTH));
                    break;
                case I:
                    Log.i(TAG, builder.substring(0, LENGTH));
                    break;
                case D:
                    Log.d(TAG, builder.substring(0, LENGTH));
                    break;
                case V:
                    Log.v(TAG, builder.substring(0, LENGTH));
                    break;
                default:
                    Log.i(TAG, builder.substring(0, LENGTH));
                    break;
            }
            showLog(builder.replace(0, LENGTH, hint), type);
        }
    }
}
