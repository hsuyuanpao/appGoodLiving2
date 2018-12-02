package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class DisplayStoreActivity extends AppCompatActivity {

    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_store);

        Toolbar toolbar = findViewById(R.id.toolBarDisplayStore);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String phone = getIntent().getStringExtra("phone");
        //Toast.makeText(this, "title = "+r_title, Toast.LENGTH_SHORT).show();;
        actionBar.setTitle("        " + name);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back); //back icon on toolbar
       // actionBar.setLogo(R.drawable.ic_home);  //home icon on toolbar
      /*  actionBar.setHomeButtonEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_home);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(DisplayStoreActivity.this, MainActivity.class);

                //startActivity(intent);
                onBackPressed();
                return;
            }
        });*/


        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);

        tv1.setText(address);
        tv2.setText(phone);

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
            public void onReceivedSslError(WebView view, SslErrorHandler
                    handler, SslError error) {
                handler.proceed();
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
                return;
            case 2: //lunch
                list = Arrays.asList(getResources().getStringArray(R.array.lunch_store_url));
                url = list.get(getIntent().getIntExtra("store_no", 0));
                mWebView.loadUrl(url);
                return;
            case 3: //afternoon tea
                list = Arrays.asList(getResources().getStringArray(R.array.afternoontea_store_url));
                url = list.get(getIntent().getIntExtra("store_no", 0));
                mWebView.loadUrl(url);
                return;
            case 4: //dinner
                list = Arrays.asList(getResources().getStringArray(R.array.dinner_store_url));
                url = list.get(getIntent().getIntExtra("store_no", 0));
                mWebView.loadUrl(url);
                return;
        }
    }

        /**
         * Let's the user tap the activity icon to go 'home'.
         * Requires setHomeButtonEnabled() in onCreate().
         */
    /*    @Override
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    // ProjectsActivity is my 'home' activity
                    startActivityAfterCleanup(MainActivity.class);
                    return true;
            }
            return (super.onOptionsItemSelected(menuItem));
        }

        private void startActivityAfterCleanup(Class<?> cls) {
            //if (DisplayStoreActivity.Dao != null) projectsDao.close();
            Intent intent = new Intent(getApplicationContext(), cls);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }*/

}