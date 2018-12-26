package com.wjl.test.arouter;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wjl.test.R;


@Route(path = "/test/acarouter")
public class ArouterActivity extends AppCompatActivity {

//    private TextView tv_show_arouter;

    private String htmlConntent = "<ol type=\"1\">\n" +
            "\t\t<li>支持直接解析标准的url进行跳转，并自动注入参数到目标页面中</li>\n" +
            "\t\t<li>支持多模块工程使用</li>\n" +
            "\t\t<li>支持多个拦截器，自定义拦截顺序</li>\n" +
            "\t\t<li>支持依赖注入，可单独作为依赖注入框架使用</li>\n" +
            "\t\t<li>支持InstantRun</li>\n" +
            "\t\t<li>支持MultiDex</li>\n" +
            "\t\t<li>映射关系按组分类，多级管理，按需初始化</li>\n" +
            "\t\t<li>页面，拦截器，服务等组件均支持自动个注册到框架</li>\n" +
            "\t\t<li>支持多种方式配置转场动画</li>\n" +
            "\t\t<li>支持获取fragment</li>\n" +
            "\t\t<li>完全支持kotlin以及混编</li>\n" +
            "\t\t<li>支持三方app加固</li>\n" +
            "\t\t<li>支持生成路由文档</li>\n" +
            "\t</ol>";


    private WebView wv_webpage;
    private String fileUrl = "file:///android_asset/function.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter);
//        tv_show_arouter=findViewById(R.id.tv_show_arouter);
//        tv_show_arouter.setText(Html.fromHtml(htmlConntent));

        wv_webpage = findViewById(R.id.wv_webpage);

        initWebView();

        wv_webpage.loadUrl(fileUrl);

    }

    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        wv_webpage.addJavascriptInterface(this, "android");//添加js监听 这样html就能调用客户端
        wv_webpage.setWebChromeClient(new WebChromeClient());
        wv_webpage.setWebViewClient(new WebViewClient());

        WebSettings webSettings = wv_webpage.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js

        /**
         * LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
         * LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
         * LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
         * LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
         */
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//不使用缓存，只从网络获取数据.
        webSettings.setDefaultTextEncodingName("utf-8");
//        //支持屏幕缩放
//        webSettings.setSupportZoom(true);
//        webSettings.setBuiltInZoomControls(true);
    }


}
