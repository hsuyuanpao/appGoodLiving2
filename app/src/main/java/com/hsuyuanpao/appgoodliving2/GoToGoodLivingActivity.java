package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;

public class GoToGoodLivingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_good_living);

        Toolbar toolbar = findViewById(R.id.toolBar7);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("請按本頁下方前往好住網頁");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

       // WebView mWebView = findViewById(R.id.webView);
        //mWebView.loadUrl("http://www.0932587227.com.tw");
        //Button button = findViewById(R.id.btn1);

        PhotoView photoView1 = findViewById(R.id.photo_view1);
        photoView1.setImageResource(R.drawable.namecard1);

        PhotoView photoView2 = findViewById(R.id.photo_view2);
        photoView2.setImageResource(R.drawable.namecard2);
    }

    public void GoToGoodLivingWebsite(View view) {
        Intent intent = new Intent(this, GoToGoodLivingWebsiteActivity.class);
        startActivity(intent);

    }

    public void GoToGoodLivingBackpackWebsite(View view) {
        Intent intent = new Intent(this, GoToGoodLivingBackpackWebsiteActivity.class);
        startActivity(intent);
    }

    public void GoToGoodLivingFB(View view) {
        Intent intent = new Intent(this, GoodLivingFBActivity.class);
        startActivity(intent);
    }
}
