package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BreakfastActivity extends AppCompatActivity {
    private static final String TAG = "BreakfastActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        Toolbar toolbar = findViewById(R.id.toolBarBreakfast);
        TextView textView = findViewById(R.id.toolbarTitle);
        ImageView imageView1 = findViewById(R.id.imviewTop1);
        ImageView imageView2 = findViewById(R.id.imviewTop2);
        textView.setText("早餐推薦");

        ListView list = findViewById(R.id.listEat);
        Log.d(TAG, "onCreate: Started.");

        final ArrayList names = new ArrayList<>();
        final ArrayList addresses = new ArrayList();
        final ArrayList phones = new ArrayList();
        final ArrayList name_only = new ArrayList();

        names.add("1.　東記永和豆漿　　>>");
        names.add("2.　共匪的店　　　　>>");
        names.add("3.　飛在香菇肉羹　　>>");
        names.add("4.　輝煌牛肉湯　　　>>");
        names.add("5.　瑞文煎盤粿　　　>>");
        names.add("6.　老等油飯麵線糊　>>");
        names.add("7.　肉粽財　　　　　>>");
        names.add("8.　土城土魠魚羹　　>>");
        names.add("9.　陳家煎盤粿　　　>>");
        names.add("10．阿國黑豆漿　　　>>");
        names.add("11．阿豐麵線糊　　　>>");

        addresses.add("地址: 651雲林縣北港鎮文化路91號");
        addresses.add("地址: 651雲林縣北港鎮公民路");
        addresses.add("地址: 651雲林縣北港鎮公民路17號");
        addresses.add("地址: 651雲林縣北港鎮博愛路136之4號");
        addresses.add("地址: 651雲林縣北港鎮大同路70號");
        addresses.add("地址: 651雲林縣北港鎮中秋路87號");
        addresses.add("地址: 651雲林縣北港鎮益安路97號");
        addresses.add("地址: 651雲林縣北港鎮雲林縣北港鎮中華路5號");
        addresses.add("地址: 651雲林縣北港鎮光明路84號");
        addresses.add("地址: 651雲林縣北港鎮博愛路35之3號");
        addresses.add("地址: 651雲林縣北港鎮中正路24號");

        phones.add("電話: 05 782 1902");
        phones.add("電話: 0912 314 001");
        phones.add("電話: 05 773 0878");
        phones.add("電話: 05 782 1980");
        phones.add("電話: ");
        phones.add("電話: 0938 906 338");
        phones.add("電話: 05 782 4845");
        phones.add("電話: 05 773 1690");
        phones.add("電話: 0927 252 833");
        phones.add("電話: 05 773 0537");
        phones.add("電話: 0911 100 679");

        name_only.add("東記永和豆漿");
        name_only.add("共匪的店");
        name_only.add("飛在香菇肉羹");
        name_only.add("輝煌牛肉湯");
        name_only.add("瑞文煎盤粿");
        name_only.add("老等油飯麵線糊");
        name_only.add("肉粽財");
        name_only.add("土城土魠魚羹");
        name_only.add("陳家煎盤粿");
        name_only.add("阿國黑豆漿");
        name_only.add("阿豐麵線糊");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_breakfast_layout, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {    // i 早餐店編號; 1 代表早餐
                Log.d(TAG, "onItemClick: name: " + names.get(i));
               // Toast.makeText(BreakfastActivity.this, "You clicked on: " + names.get(i), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(BreakfastActivity.this, DisplayStoreActivity.class);
                intent.putExtra("name", name_only.get(i).toString());
                intent.putExtra("address", addresses.get(i).toString());
                intent.putExtra("phone", phones.get(i).toString());
                intent.putExtra("meal_class", 1);
                intent.putExtra("store_no", i);

                startActivity(intent);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,"back to last page: is clicked...");
                //Intent intent1 = new Intent(BreakfastActivity.this, EatActivity.class);
                //startActivity(intent1);
                finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(BreakfastActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
