package com.hsuyuanpao.appgoodliving2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import java.net.MalformedURLException;
import java.net.URL;
public class GoToGoodLivingBackpackWebsiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_good_living_backpack_website);

        WebView mWebView = findViewById(R.id.webView);
        mWebView.loadUrl("http://www.hodua-beigang.com/product.php?lang=tw&tb=1&cid=5");
    }
}
