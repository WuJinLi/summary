package com.wjl.test.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * author: WuJinLi
 * time  : 2018/12/27
 * desc  :
 */
public class ToastUtils {


    public static void showToastShort(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


    public static void showToastLong(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
