package com.hsuyuanpao.appgoodliving2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

import java.util.Arrays;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class DisplayStoreActivity extends AppCompatActivity {
    private static final String TAG = "DispStoreActivity";
    private List<String> list;
    private static ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_store);

        Toolbar toolbar = findViewById(R.id.toolBarDisplayStore);

        TextView textView = findViewById(R.id.toolbarTitle);
        imageView1 = findViewById(R.id.imviewTop1);
        imageView2 = findViewById(R.id.imviewTop2);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String phone = getIntent().getStringExtra("phone");

        textView.setText(name); //在工具列中央，顯示店名

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);

        tv1.setText(address);   //顯示地址
        tv2.setText(phone);     //顯示電話

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

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                final SslErrorHandler mHandler ;
                mHandler= handler;
                AlertDialog.Builder builder = new AlertDialog.Builder(DisplayStoreActivity.this);
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
                dialog.show();
            }
    });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin,
                                                           GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        int i = getIntent().getIntExtra("meal_class", 0); // get meal class no.
        switch (i) {
            case 1: //breakfast
                list = Arrays.asList(getResources().getStringArray(R.array.breakfast_store_url));
                String url = list.get(getIntent().getIntExtra("store_no", 0));
                mWebView.loadUrl(url);
                lastpage_or_home(i);

                break;
            case 2: //lunch
                list = Arrays.asList(getResources().getStringArray(R.array.lunch_store_url));
                url = list.get(getIntent().getIntExtra("store_no", 0));
                mWebView.loadUrl(url);
                lastpage_or_home(i);

                break;
            case 3: //afternoon tea
                list = Arrays.asList(getResources().getStringArray(R.array.afternoontea_store_url));
                url = list.get(getIntent().getIntExtra("store_no", 0));
                mWebView.loadUrl(url);
                lastpage_or_home(i);

                break;
            case 4: //dinner
                list = Arrays.asList(getResources().getStringArray(R.array.dinner_store_url));
                url = list.get(getIntent().getIntExtra("store_no", 0));
                mWebView.loadUrl(url);
                lastpage_or_home(i);

                break;
        }
    }

    private void lastpage_or_home(final int i){
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Log.d(TAG,"back to last page: is clicked..., and i = "+i );
                switch(i){
                    case 1:
                       //Intent intent1 = new Intent(DisplayStoreActivity.this, BreakfastActivity.class);
                        //startActivity(intent1);
                        finish();
                        break;
                    case 2:
                        Intent intent2 = new Intent(DisplayStoreActivity.this, LunchActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(DisplayStoreActivity.this, AfternoonteaActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(DisplayStoreActivity.this, DinnerActivity.class);
                        startActivity(intent4);
                        break;
                }*/
                finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(DisplayStoreActivity.this, MainActivity.class);
                startActivity(intent5);
            }
        });
    }
}
