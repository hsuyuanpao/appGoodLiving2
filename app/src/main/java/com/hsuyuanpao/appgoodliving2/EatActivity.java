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
        actionBar.setTitle("吃吃喝喝推薦");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

    }

    public void GoToBreakfast(View view) {
        Intent intent = new Intent(this, GoToBreakfastActivity.class);
        startActivity(intent);

    }
}
