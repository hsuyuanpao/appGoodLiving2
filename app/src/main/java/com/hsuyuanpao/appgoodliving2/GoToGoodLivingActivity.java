package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;

public class GoToGoodLivingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_good_living);

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
}
