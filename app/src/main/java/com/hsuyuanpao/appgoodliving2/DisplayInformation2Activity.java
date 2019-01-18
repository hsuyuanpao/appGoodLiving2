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
        TextView tvaddress = findViewById(R.id.tv1);
        TextView tvphone = findViewById(R.id.tv2);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String phone = getIntent().getStringExtra("phone");

        textView.setText(name);
        tvaddress.setText("地址: " + address);
        tvphone.setText("電話: " + phone);
        int no = getIntent().getIntExtra("no",0);
        if(no == 29){
            iv.setImageResource(R.drawable.hst_schedule1);
        }
        else {
            iv.setImageResource(R.drawable.mazu_schedule1);
        }
    }

    public void LastPage(View view){
        //Intent intent = new Intent(this, Information2Activity.class);
        //startActivity(intent);
        finish();
    }

    public void HomePage(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
