package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {
    private static final String TAG = "InformationActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar toolbar = findViewById(R.id.toolbarTop);
        TextView textView = findViewById(R.id.toolbarTitle);
        textView.setText("交 通 資 訊 報 馬 仔");

        ListView list = findViewById(R.id.listviewInfo);

        final ArrayList names = new ArrayList();
        final ArrayList name_only = new ArrayList();

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
        names.add("１６　164 縣道　　　　　　　　　>>");
        names.add("１７　145 縣道　　　　　　　　　>>");
        names.add("１８　159 縣道　　　　　　　　　>>");
        names.add("１９　高鐵接駁車資訊　　　　　　>>");
        names.add("２０　北港媽祖醫院免費接駁資訊　>>");

        name_only.add("朝天宮");
        name_only.add("武德宮");
        name_only.add("北港圖書館");
        name_only.add("北港文化中心");
        name_only.add("建國中學");
        name_only.add("北港高中");
        name_only.add("北港國中");
        name_only.add("北港媽祖醫院");
        name_only.add("北港鎮公所免費停車場");
        name_only.add("北港遊客中心");
        name_only.add("全家(北港天后店)-中山路");
        name_only.add("7-11(朝天宮門市)-中山路");
        name_only.add("台西客運北港站");
        name_only.add("統聯客運北港站");
        name_only.add("嘉義客運北港站");
        name_only.add("164 縣道");
        name_only.add("145 縣道");
        name_only.add("159 縣道");
        name_only.add("高鐵接駁車資訊");
        name_only.add("北港媽祖醫院免費接駁資訊");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_information_layout, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {// i 早餐店編號; 1 代表早餐
                //Log.d(TAG, "onItemClick: name: " + names.get(i));
                Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(InformationActivity.this, DisplayInformationActivity.class);
                intent.putExtra("name", name_only.get(i).toString());
                intent.putExtra("no", i); //傳編號
                startActivity(intent);
            }
        });
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
