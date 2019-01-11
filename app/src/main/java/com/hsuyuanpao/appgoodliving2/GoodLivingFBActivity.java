package com.hsuyuanpao.appgoodliving2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodLivingFBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_living_fb);
        Toolbar toolbar = findViewById(R.id.toolBar6);

        TextView tvTitle = findViewById(R.id.toolbarTitle);
        ImageView imTop1 = findViewById(R.id.imviewTop1);
        ImageView imTop2 = findViewById(R.id.imviewTop2);
        //String name = getIntent().getStringExtra("title");   //景點名稱
        //Toast.makeText(this, "Information of no: " + no, Toast.LENGTH_SHORT).show();
        tvTitle.setText("好住民宿臉書");

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
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(GoodLivingFBActivity.this);
                //builder.setMessage(R.string.notification_error_ssl_cert_invalid);
                builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.proceed();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.cancel();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
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
      //  String url = getIntent().getStringExtra("urlString");
        mWebView.loadUrl("https://www.facebook.com/0932587227.com.tw/");

        imTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1 = new Intent(GoodLivingFBActivity.this, GoToGoodLivingActivity.class);
                //startActivity(intent1);
                finish();
            }
        });

        imTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(GoodLivingFBActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
