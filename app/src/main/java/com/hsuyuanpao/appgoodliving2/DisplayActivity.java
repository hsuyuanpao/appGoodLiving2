package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    private static final String TAG = "DisplayActivity";
    private int[] images = {R.drawable.temple, R.drawable.oldstreet, R.drawable.daughterbridge,
            R.drawable.cattlemarket, R.drawable.watertower, R.drawable.drawingcommunity,
            R.drawable.workshop, R.drawable.wudetemple, R.drawable.bridge, R.drawable.yimintemple};
    private int[] imMap = {R.drawable.temple_map, R.drawable.oldstreet_map, R.drawable.daughterbridge_map,
                        R.drawable.cattlemarket_map, R.drawable.watertower_map, R.drawable.drawingcommunity_map,
                        R.drawable.workshop_map, R.drawable.wudetemple_map, R.drawable.bridge_map, R.drawable.yimintemple_map};

    ImageView imageView;
    ImageView imageView2;
    TextView  textView;
    TextView  textView2;

    private List<String> listIG;
    private List<String> listFB;
    private static int i;
    private String igurl, fburl;
    private static String r_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Toolbar toolbar = findViewById(R.id.toolBar3);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        String title = getIntent().getStringExtra("image_title");
        if(title != null){//判斷是返回，還是新點選的景點。如果是返回則title會是空的!
            r_title = title;
            i = getIntent().getIntExtra("image",0);
        }
        //Toast.makeText(this, "title = "+r_title, Toast.LENGTH_SHORT).show();;
        actionBar.setTitle(r_title);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        imageView = findViewById(R.id.imageDisplay);
        imageView2 = findViewById(R.id.imageDisplay2);
        textView = findViewById(R.id.textTitle);
        textView2 = findViewById(R.id.textDesc);
     /*   ivlogo1 = findViewById(R.id.maplogo);
        ivlogo2 = findViewById(R.id.iglogo);
        ivlogo3 = findViewById(R.id.fblogo);*/

        listIG = Arrays.asList(getResources().getStringArray(R.array.attraction_igurl));
        listFB = Arrays.asList(getResources().getStringArray(R.array.attraction_fburl));


        textView.setText(r_title);
        Log.d(TAG,"onCreate : get image title...");
        //i = getIntent().getIntExtra("image",0);
        textView2.setText(getIntent().getStringExtra("image_description"));
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());

        //i = getIntent().getIntExtra("image",0);

        imageView.setBackgroundResource(images[i]);
        imageView2.setBackgroundResource(imMap[i]);
        igurl = listIG.get(i);  //取得ig網址
        fburl = listFB.get(i);  //取得fb網址
        Log.d(TAG,"onCreate : get igurl..."+ igurl);
        //Toast.makeText(this, "image no. = "+ i, Toast.LENGTH_SHORT).show();;

    }

    public void GoToMapsActivity(View view) {
        Log.d(TAG,"MapsActivity: is preparing to run...");
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void GoToIGActivity(View view) {
        Log.d(TAG,"IGActivity: is preparing to run...");
        Intent intent = new Intent(this, IGActivity.class);
        intent.putExtra("urlString",igurl);
        intent.putExtra("title",r_title);
        startActivity(intent);
    }

    public void GoToFBActivity(View view) {
        Log.d(TAG,"FGActivity: is preparing to run...");
        Intent intent = new Intent(this, FBActivity.class);
        intent.putExtra("urlString",fburl);
        intent.putExtra("title",r_title);
        startActivity(intent);
    }
}

