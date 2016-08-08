package com.tydc.tigerschool.core.utils;

import android.util.Log;

/**
 * 打印日志
 *
 * 输出日志到文件
 */
public class CLog {

   private final static boolean isDebug=true;


    public static void d(String tag, String msg) {
        if(isDebug){
            Log.d(tag,msg);
        }

    }

    public static void i(String tag, String msg) {
        if(isDebug){
            Log.i(tag,msg);
        }
    }

    public static void e(String tag, String msg) {
        if(isDebug){
            Log.e(tag,msg);
        }
    }


}


