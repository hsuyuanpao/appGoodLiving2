package com.hsuyuanpao.appgoodliving2;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.StrictMode;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.support.v7.widget.Toolbar;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class IGActivity extends AppCompatActivity {
    private static final String TAG = "IGActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ig);

        Toolbar toolbar = findViewById(R.id.toolBar5);

        TextView tvTitle = findViewById(R.id.toolbarTitle);
        ImageView imTop1 = findViewById(R.id.imviewTop1);
        ImageView imTop2 = findViewById(R.id.imviewTop2);
        tvTitle.setText("Instagram");

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

        Log.d(TAG,"onCreate: preparing to open IG website...");

        String url = getIntent().getStringExtra("urlString");


        mWebView.loadUrl(url);

        imTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(IGActivity.this, DisplayActivity.class);
                startActivity(intent1);
            }
        });

        imTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(IGActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });

    }

 }
