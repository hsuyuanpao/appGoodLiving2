package com.hsuyuanpao.appgoodliving2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Information2Webpage extends AppCompatActivity {
    private static final String TAG = "Info2Webpage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information2_webpage);

        Toolbar toolbar = findViewById(R.id.toolBarInfo2Webpage);

        TextView tvTitle = findViewById(R.id.toolbarTitle);
        ImageView imTop1 = findViewById(R.id.imviewTop1);
        ImageView imTop2 = findViewById(R.id.imviewTop2);
        String name = getIntent().getStringExtra("name");   //名稱
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
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                handler.cancel();
                /*final AlertDialog.Builder builder = new AlertDialog.Builder(Information2Webpage.this);
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
                dialog.show();*/
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
        int no = getIntent().getIntExtra("no", 0);   // information location no.

        Log.d(TAG, "name: " + name + "no:" + no);
        if(no == 20)
        {
            String url = "http://5151.tw/city2.php?areaid=&areaid2=651&type=CM";
            mWebView.loadUrl(url);
        }
        else
        {
            String url = "https://sheethub.com/data.fda.gov.tw/%E8%97%A5%E5%B1%80%E5%9F%BA%E6%9C%AC%E8%B3%87%E6%96%99/i/87/%E9%9B%B2%E6%9E%97%E7%B8%A3/%E5%8C%97%E6%B8%AF%E9%8E%AE";
            mWebView.loadUrl(url);
        }

        imTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1 = new Intent(Information2Webpage.this, Information2Activity.class);
                //startActivity(intent1);
                finish();
            }
        });

        imTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Information2Webpage.this, MainActivity.class);
                startActivity(intent2);
            }
        });

    }

}
