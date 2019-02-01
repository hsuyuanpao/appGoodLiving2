package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class GoToGoodLivingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_good_living);

        TextView tvTitle = findViewById(R.id.toolbarTitle);
        ImageView imTop1 = findViewById(R.id.imviewTop1);
        ImageView imTop2 = findViewById(R.id.imviewTop2);

        tvTitle.setText("好住民宿相關連結");

       // WebView mWebView = findViewById(R.id.webView);
        //mWebView.loadUrl("http://www.0932587227.com.tw");
        //Button button = findViewById(R.id.btn1);

        PhotoView photoView1 = findViewById(R.id.photo_view1);
        photoView1.setImageResource(R.drawable.namecard1);

        PhotoView photoView2 = findViewById(R.id.photo_view2);
        photoView2.setImageResource(R.drawable.namecard2);

        imTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(GoToGoodLivingActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }

    public void GoToGoodLivingWebsite(View view) {
        final ImageView im = findViewById(R.id.imH1);
        im.setBackgroundResource(R.drawable.orange_1_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.orange_1);
            }
        }, 100);
        Intent intent = new Intent(this, GoToGoodLivingWebsiteActivity.class);
        startActivity(intent);

    }

    public void GoToGoodLivingFB(View view) {
        final ImageView im = findViewById(R.id.imH2);
        im.setBackgroundResource(R.drawable.blue_1_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.blue_1);
            }
        }, 100);
        Intent intent = new Intent(this, GoodLivingFBActivity.class);
        startActivity(intent);
    }


    public void GoToGoodLivingBackpackWebsite(View view) {
        final ImageView im = findViewById(R.id.imH3);
        im.setBackgroundResource(R.drawable.orange2_1_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.orange2_1);
            }
        }, 100);
        Intent intent = new Intent(this, GoToGoodLivingBackpackWebsiteActivity.class);
        startActivity(intent);
    }


    public void GoToGoodLivingBackpackFB(View view) {
        final ImageView im = findViewById(R.id.imH4);
        im.setBackgroundResource(R.drawable.blue2_1_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.blue2_1);
            }
        }, 100);
        Intent intent = new Intent(this, BackpackFBActivity.class);
        startActivity(intent);
    }
}
