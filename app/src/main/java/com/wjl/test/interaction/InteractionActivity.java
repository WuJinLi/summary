package com.wjl.test.interaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wjl.test.R;


@Route(path = "/test/interaction")
public class InteractionActivity extends AppCompatActivity {

    private WebView wv_webview;
    private Button btn_h5_function;
    private int version = Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);
        wv_webview = findViewById(R.id.wv_webview);
        btn_h5_function = findViewById(R.id.btn_h5_function);
        wv_webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(InteractionActivity.this);
                b.setTitle("Alert");
                b.setMessage(message);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();
                return true;
            }
        });
        wv_webview.setWebViewClient(new WebViewClient());


        WebSettings webSettings = wv_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        wv_webview.addJavascriptInterface(new AndroidJS(InteractionActivity.this), "AndroidJS");


        wv_webview.loadUrl("file:///android_asset/interaction.html");


        btn_h5_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (version < 18) {
                    wv_webview.loadUrl("javascript:doAlert()");
                } else {
                    wv_webview.evaluateJavascript("javascript:doAlert()", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            //value 为js处理返回的结果
                        }
                    });
                }
            }
        });
    }
}
