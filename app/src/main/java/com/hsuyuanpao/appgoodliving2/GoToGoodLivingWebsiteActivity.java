package com.hsuyuanpao.appgoodliving2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class GoToGoodLivingWebsiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_good_living_website);

        Toolbar toolbar = findViewById(R.id.toolBar7);
        TextView textView = findViewById(R.id.toolbarTitle);
        ImageView imageView1 = findViewById(R.id.imviewTop1);
        ImageView imageView2 = findViewById(R.id.imviewTop2);
        textView.setText("好住民宿網頁");

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
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.cancel();
                /*final SslErrorHandler mHandler ;
                mHandler= handler;
                AlertDialog.Builder builder = new AlertDialog.Builder(GoToGoodLivingWebsiteActivity.this);
                builder.setMessage("ssl證書驗證失敗");
                builder.setPositiveButton("繼續", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mHandler.proceed();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mHandler.cancel();
                    }
                });
                builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                            mHandler.cancel();
                            dialog.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();*/
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin,
                                                           GeolocationPermissions.Callback callback)
            {
                callback.invoke(origin,true,false);
            }
        });
        //String url = getIntent().getStringExtra("urlString");
        mWebView.loadUrl("http://www.hodua-beigang.com/product.php?lang=tw&tb=1");

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1 = new Intent(GoToGoodLivingWebsiteActivity.this, GoToGoodLivingActivity.class);
                //startActivity(intent1);
                finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(GoToGoodLivingWebsiteActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
