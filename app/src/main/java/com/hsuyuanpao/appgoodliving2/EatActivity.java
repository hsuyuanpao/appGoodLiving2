package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EatActivity extends AppCompatActivity {
    private static final String TAG = "EatActivity";
    private ImageView imBreakfast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        //Toolbar toolbar = findViewById(R.id.toolbarAttractions);

        TextView tvTitle = findViewById(R.id.toolbarTitle);
        ImageView imTop1 = findViewById(R.id.imviewTop1);
        ImageView imTop2 = findViewById(R.id.imviewTop2);


        tvTitle.setText(" 吃吃喝喝推薦");


       /* ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("       ");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);*/

        imTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(EatActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });

    }

    public void GoToBreakfast(View view) {
        final ImageView im = findViewById(R.id.imBreakfast);
        im.setBackgroundResource(R.drawable.eat1_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.eat1);
            }
        }, 100);
        Log.d(TAG,"go to breakfast page: is clicked...");
        Intent intent1 = new Intent(this, BreakfastActivity.class);
        startActivity(intent1);

    }

    public void GoToLunch(View view) {
        final ImageView im = findViewById(R.id.imLunch);
        im.setBackgroundResource(R.drawable.eat2_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.eat2);
            }
        }, 100);
        Log.d(TAG,"go to lunch page: is clicked...");
        Intent intent2 = new Intent(this, LunchActivity.class);
        startActivity(intent2);
    }

    public void GoToAfternoontea(View view) {
        final ImageView im = findViewById(R.id.imAfternoontea);
        im.setBackgroundResource(R.drawable.eat3_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.eat3);
            }
        }, 100);
        Log.d(TAG,"go to afternoontea page: is clicked...");
        Intent intent3 = new Intent(this, AfternoonteaActivity.class);
        startActivity(intent3);
    }

    public void GoToDinner(View view) {
        final ImageView im = findViewById(R.id.imDinner);
        im.setBackgroundResource(R.drawable.eat4_2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                im.setBackgroundResource(R.drawable.eat4);
            }
        }, 100);
        Log.d(TAG,"go to dinner page: is clicked...");
        Intent intent4 = new Intent(this, DinnerActivity.class);
        startActivity(intent4);
    }
}
