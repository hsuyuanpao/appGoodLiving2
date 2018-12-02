package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        textView.setText("交 通 資 訊 報 馬 仔");

        ListView list = findViewById(R.id.listviewInfo);

        final ArrayList names = new ArrayList();

        names.add("１　　朝天宮　　　　　　　　　　>>");
        names.add("２　　武德宮　　　　　　　　　　>>");
        names.add("３　　北港圖書館　　　　　　　　>>");
        names.add("４　　北港文化中心　　　　　　　>>");
        names.add("５　　建國中學　　　　　　　　　>>");
        names.add("６　　北港高中　　　　　　　　　>>");
        names.add("７　　北港國中　　　　　　　　　>>");
        names.add("８　　北港媽祖醫院　　　　　　　>>");
        names.add("９　　北港鎮公所免費停車場　　　>>");
        names.add("１０　北港遊客中心　　　　　　　>>");
        names.add("１１　全家(北港天后店)-中山路　　>>");
        names.add("１２　7-11(朝天宮門市)-中山路　　>>");
        names.add("１３　台西客運北港站　　　　　　>>");
        names.add("１４　統聯客運北港站　　　　　　>>");
        names.add("１５　嘉義客運北港站　　　　　　>>");
        names.add("１６　高鐵接駁車資訊　　　　　　>>");
        names.add("１７　北港媽祖醫院免費接駁資訊　>>");
        names.add("１８　164 縣道　　　　　　　　　>>");
        names.add("１９　145 縣道　　　　　　　　　>>");
        names.add("２０　158 縣道　　　　　　　　　>>");

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
