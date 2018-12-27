package com.wjl.test.interaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wjl.test.R;
import com.wjl.test.utils.ToastUtils;

import java.util.HashMap;
import java.util.Set;


@Route(path = "/test/interaction")
public class InteractionActivity extends AppCompatActivity {

    private WebView wv_webview;
    private Button btn_h5_function;
    private int version = Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);
        wv_webview = findViewById(R.id.wv_webview);
        btn_h5_function = findViewById(R.id.btn_h5_function);
        wv_webview.setWebChromeClient(new WebChromeClient() {

            // 参数message:代表promt（）的内容（不是url）
            // 参数result:代表输入框的返回值
            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult
                    result) {

                Uri uri = Uri.parse(message);

                // 根据协议的参数，判断是否是所需要的url(原理同方式2)
                // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
                if ("js".equals(uri.getScheme())) {
                    // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                    // 所以拦截url,下面JS开始调用Android需要的方法
                    if ("demo".equals(uri.getAuthority())) {
                        StringBuilder stringBuilder = new StringBuilder();
                        Set<String> set = uri.getQueryParameterNames();
                        for (String key : set) {
                            stringBuilder.append(key + ":" + uri.getQueryParameter(key));
                        }
                        ToastUtils.showToastLong(InteractionActivity.this, "WebChromeClient方法实现" + stringBuilder
                                .toString
                                        ());
                        result.confirm(stringBuilder.toString());
                        return true;
                    }
                }

                return super.onJsPrompt(view, url, message, defaultValue, result);
            }


            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }
        });
        wv_webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();

                // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）

                // 如果url的协议 = 预先约定的 js 协议
                // 就解析往下解析参数
                if ("js".equals(uri.getScheme())) {
                    // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                    // 所以拦截url,下面JS开始调用Android需要的方法
                    if ("webview".equals(uri.getAuthority())) {
                        //  步骤3：
                        // 执行JS所需要调用的逻辑

                        StringBuilder stringBuilder = new StringBuilder();
                        //获取地址的传参key的集合
                        Set<String> collection = uri.getQueryParameterNames();
                        //获取数据
                        for (String key : collection) {
                            stringBuilder.append(key + ":" + uri.getQueryParameter(key) + " ");
                        }
                        ToastUtils.showToastShort(InteractionActivity.this, "WebViewClient方法实现" + stringBuilder
                                .toString());
                    }
                }
                return true;
            }
        });
        WebSettings webSettings = wv_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);


        //添加支持js方法：new AndroidJS(InteractionActivity.this)是android代码中对象，AndroidJS是js代码中new AndroidJS
        // (InteractionActivity.this)的别名
        wv_webview.addJavascriptInterface(new AndroidJS(InteractionActivity.this), "AndroidJS");

        //加载h5界面
        wv_webview.loadUrl("file:///android_asset/interaction.html");


        btn_h5_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (version < 18) {
                    wv_webview.loadUrl("javascript:androidCallJs()");
                } else {
                    wv_webview.evaluateJavascript("javascript:androidCallJs()", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            //value 为js处理返回的结果
//                            btn_h5_function.setText(value);
                        }
                    });
                }
            }
        });

    }


}
