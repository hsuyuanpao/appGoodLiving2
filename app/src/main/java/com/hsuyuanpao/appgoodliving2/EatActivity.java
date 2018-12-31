package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EatActivity extends AppCompatActivity {
    private static final String TAG = "EatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        Toolbar toolbar = findViewById(R.id.toolBarEat);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("        吃吃喝喝推薦");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

    }

    public void GoToBreakfast(View view) {
        Log.d(TAG,"go to breakfast page: is clicked...");
        Intent intent1 = new Intent(this, GoToBreakfastActivity.class);
        startActivity(intent1);

    }

    public void GoToLunch(View view) {
        Log.d(TAG,"go to lunch page: is clicked...");
        Intent intent2 = new Intent(this, LunchActivity.class);
        startActivity(intent2);
    }

    public void GoToAfternoontea(View view) {
        Log.d(TAG,"go to afternoontea page: is clicked...");
        Intent intent3 = new Intent(this, AfternoonteaActivity.class);
        startActivity(intent3);
    }

    public void GoToDinner(View view) {
        Log.d(TAG,"go to dinner page: is clicked...");
        Intent intent4 = new Intent(this, DinnerActivity.class);
        startActivity(intent4);
    }
}
