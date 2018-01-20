package com.importdemolibrary;

import android.util.Log;

/**
 * Created by wang on 2018/1/20 0020.
 * Log 帮助类
 */

public class L {
    private static String TAG = "InputMessage：";

    //不可被实例化
    private L() {

    }

    public static void e(String message) {
        if (message.isEmpty()) {
            Log.e(TAG, message);
        }
    }
}
