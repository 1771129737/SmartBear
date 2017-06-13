package com.example.zy.smartbear.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by ZhangYin on 2017/6/12.
 */

public class SharedP {
    private static final String TAG = "SharedP";
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharedP(Context context, String fileName, int mode) {

        if (null == fileName || "".equals(fileName)) {
            fileName = "default";
            Logs.i(TAG, "fileName is null or length = 0 used \"default\"");
        }

        try {
            sp = context.getSharedPreferences(fileName, mode);
        } catch (Exception e) {
            sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
            Logs.e(TAG, "get SharedPreferences is ERROR used mode:Context.MODE_PRIVATE   ", e.getMessage());
        }
        editor = sp.edit();
    }


    public SharedP set(String key, Object value) {

        if (null == value) {
            return null;
        }

        if (null != key) {

            if (value instanceof String) {
                editor.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editor.putInt(key, (Integer) value);
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
            } else if (value instanceof Float) {
                editor.putFloat(key, (Float) value);
            } else if (value instanceof Long) {
                editor.putLong(key, (Long) value);
            } else {
                Logs.e(TAG, "ERROR type => set: in else", value);
            }
            editor.commit();
        }
        return this;
    }


    public Object get(String key, Object value) {

        if (null == value) {
            return null;
        }

        if (value instanceof String) {
            return sp.getString(key, (String) value);
        } else if (value instanceof Integer) {
            return sp.getInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            return sp.getFloat(key, (Float) value);
        } else if (value instanceof Long) {
            return sp.getLong(key, (Long) value);
        } else {
            Logs.i(TAG, "ERROR type => get: in else", value);
        }

        return value;
    }

    public void remove(String key) {
        editor.remove(key).commit();
    }

    public void clear() {
        editor.clear().commit();
    }

    public void register(SharedPreferences.OnSharedPreferenceChangeListener listener) {

        if (null != listener) {
            sp.registerOnSharedPreferenceChangeListener(listener);
        }
    }

    public void unregister(SharedPreferences.OnSharedPreferenceChangeListener listener) {

        if (null != listener) {
            sp.unregisterOnSharedPreferenceChangeListener(listener);
        }
    }
    public Map<String, ?> getALL(){
        return sp.getAll();
    }
}
