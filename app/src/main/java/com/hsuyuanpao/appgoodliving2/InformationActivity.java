package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar toolbar = findViewById(R.id.toolbarTop);
        TextView textView = findViewById(R.id.toolbarTitle);
        textView.setText("報馬仔");

        ListView list = findViewById(R.id.listviewInfo);

        final ArrayList names = new ArrayList();

        names.add("　　１．　東記永和豆漿　　　　>>");
        names.add("　　２．　共匪的店　　　　　　>>");
        names.add("　　３．　飛在香菇肉羹　　　　>>");
        names.add("　　４．　輝煌牛肉湯　　　　　>>");
        names.add("　　５．　瑞文煎盤粿　　　　　>>");
        names.add("　　６．　老等油飯麵線糊　　　>>");
        names.add("　　７．　肉粽財　　　　　　　>>");
        names.add("　　８．　土城土魠魚羹　　　　>>");
        names.add("　　９．　陳家煎盤粿　　　　　>>");
        names.add("　　１０．阿國黑豆漿　　　　　>>");
        names.add("　　１１．阿豐麵線糊　　　　　>>");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_information_layout, names);
        list.setAdapter(adapter);
    }

    public void LastPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void HomePage(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
