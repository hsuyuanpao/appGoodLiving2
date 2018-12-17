package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayInformation2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_information2);

        //Toolbar toolbar = findViewById(R.id.toolbarTop2);
        TextView textView = findViewById(R.id.toolbarTitle);
        ImageView iv = findViewById(R.id.imView1);
        String name = getIntent().getStringExtra("name");
        textView.setText(name);
        int no = getIntent().getIntExtra("no",0);
        if(no == 18){
            iv.setImageResource(R.drawable.hst_schedule1);
        }
        else {
            iv.setImageResource(R.drawable.mazu_schedule1);
        }
    }

    public void LastPage(View view){
        Intent intent = new Intent(this, InformationActivity.class);
        startActivity(intent);
    }

    public void HomePage(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}