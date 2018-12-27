package com.wjl.test.interaction;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.wjl.test.R;

/**
 * author: WuJinLi
 * time  : 2018/12/26
 * desc  : js调用android原生发的实现类，类中包含的js需要android原生实现的所有的方法
 */
public class AndroidJS extends Object {
    private Context context;

    public AndroidJS(Context context) {
        this.context = context;
    }


    @JavascriptInterface
    public void showBookList() {
        new AlertDialog.Builder(context)
                .setTitle("图书列表")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(
                        new String[]{"疯狂java讲义", "疯狂Android讲义",
                                "轻量级java EE开发"}, null)
                .setPositiveButton("确定", null).create().show();
    }

    @JavascriptInterface
    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
