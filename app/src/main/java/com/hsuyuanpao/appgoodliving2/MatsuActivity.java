package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class MatsuActivity extends AppCompatActivity {
    private static final String TAG = "MatsuActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matsu);

        Toolbar toolbar = findViewById(R.id.toolBarMatsu);

        TextView tvTitle = findViewById(R.id.toolbarTitle);
        ImageView imTop1 = findViewById(R.id.imviewTop1);
        ImageView imTop2 = findViewById(R.id.imviewTop2);
        String name = getIntent().getStringExtra("image_title");   //景點名稱
        //Toast.makeText(this, "Information of no: " + no, Toast.LENGTH_SHORT).show();
        tvTitle.setText(name);

        WebView mWebView = findViewById(R.id.webView);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setGeolocationEnabled(true);

        mWebView.setWebViewClient(new WebViewClient()
        {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler
                    handler, SslError error)
            {
                handler.proceed();
            }
        });
        //mWebView.loadUrl("https://192.168.2.29/ccc/");

        mWebView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin,
                                                           GeolocationPermissions.Callback callback)
            {
                callback.invoke(origin,true,false);
            }
        });

        Log.d(TAG,"onCreate: preparing to open Matsu website...");

        String url = "http://www.matsu.org.tw/index2.aspx";


        mWebView.loadUrl(url);

        imTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1 = new Intent(MatsuActivity.this, AttrcationsNearByCVActivity.class);
                //startActivity(intent1);
                finish();
            }
        });

        imTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MatsuActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });

    }

}
