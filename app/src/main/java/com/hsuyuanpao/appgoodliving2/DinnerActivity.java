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

public class DinnerActivity extends AppCompatActivity {
    private static final String TAG = "DinnerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        Toolbar toolbar = findViewById(R.id.toolBarDinner);
        TextView textView = findViewById(R.id.toolbarTitle);
        ImageView imageView1 = findViewById(R.id.imviewTop1);
        ImageView imageView2 = findViewById(R.id.imviewTop2);
        textView.setText("晚餐推薦");

        ListView list = findViewById(R.id.listDinner);
        Log.d(TAG, "onCreate: Started.");

        final ArrayList names = new ArrayList<>();
        final ArrayList addresses = new ArrayList();
        final ArrayList phones = new ArrayList();
        final ArrayList name_only = new ArrayList();

        names.add("1.　九久醇義麵坊　　　>>");
        names.add("2.　加運包子店　　　　>>");
        names.add("3.　田仔羊肉米糕　　　>>");
        names.add("4.　阿扁麻醬麵　　　　>>");
        names.add("5.　郎土魠魚羹　　　　>>");
        names.add("6.　北港一尾魚　　　　>>");
        names.add("7.　圓環滷肉飯　　　　>>");
        names.add("8.　圓環滷味　　　　　>>");
        names.add("9.　新味珍原汁牛肉麵　>>");
        names.add("10．阿敏蟳羹豬腳　　　>>");
        names.add("11．阿不倒排骨飯　　　>>");
        names.add("12．秋月生炒鱔魚　　　>>");
        names.add("13．瘦仔麵攤　　　　　>>");
        names.add("14．北港清粥小菜　　　>>");
        names.add("15．青松餐廳　　　　　>>");
        names.add("16．吉輝餐廳　　　　　>>");

        addresses.add("地址: 651雲林縣北港鎮公民路37號");
        addresses.add("地址: 651雲林縣北港鎮光明路20號");
        addresses.add("地址: 651雲林縣北港鎮大同路29號");
        addresses.add("地址: 651雲林縣北港鎮大同路22號");
        addresses.add("地址: 651雲林縣北港鎮仁和路3號");
        addresses.add("地址: 651雲林縣北港鎮民主路18號");
        addresses.add("地址: 6651雲林縣北港鎮文化路42號");
        addresses.add("地址: 651雲林縣北港鎮文化路42-2號");

        addresses.add("地址: 651雲林縣北港鎮文化路40-6號");
        addresses.add("地址: 651雲林縣北港鎮中山路82號");
        addresses.add("地址: 651雲林縣北港鎮光明路15號");
        addresses.add("地址: 651雲林縣北港鎮光明路9號");
        addresses.add("地址: 651雲林縣北港鎮光明路1號");
        addresses.add("地址: 651雲林縣北港鎮民主路39號");
        addresses.add("地址: 651雲林縣北港鎮太平路369號");
        addresses.add("地址: 651雲林縣北港鎮文化路184號之1號");

        phones.add("電話: 05 782 6727");
        phones.add("電話: 05 783 2665");
        phones.add("電話: ");
        phones.add("電話: ");
        phones.add("電話: 05 783 2923");
        phones.add("電話: ");
        phones.add("電話: ");
        phones.add("電話: 05 783 8596");

        phones.add("電話: 0937 480 073");
        phones.add("電話: 05 783 6796");
        phones.add("電話: 05 782 0125");
        phones.add("電話: 05 783 0467");
        phones.add("電話: 05 783 8408");
        phones.add("電話: 0976 569 705");
        phones.add("電話: 05 783 6548");
        phones.add("電話: 05 782 2255");

        name_only.add("九久醇義麵坊");
        name_only.add("加運包子店");
        name_only.add("田仔羊肉米糕");
        name_only.add("阿扁麻醬麵");
        name_only.add("一郎土魠魚羹");
        name_only.add("北港一尾魚");
        name_only.add("圓環滷肉飯");
        name_only.add("圓環滷味");

        name_only.add("北港新味珍原汁牛肉麵");
        name_only.add("阿敏蟳羹豬腳");
        name_only.add("阿不倒排骨飯");
        name_only.add("秋月生炒鱔魚");
        name_only.add("瘦仔麵攤");
        name_only.add("北港清粥小菜");
        name_only.add("青松餐廳");
        name_only.add("吉輝餐廳");


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_dinner_layout, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: name: " + names.get(i));
                // Toast.makeText(GoToBreakfastActivity.this, "You clicked on: " + names.get(i), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DinnerActivity.this, DisplayStoreActivity.class);
                intent.putExtra("name", name_only.get(i).toString());
                intent.putExtra("address", addresses.get(i).toString());
                intent.putExtra("phone", phones.get(i).toString());
                intent.putExtra("meal_class", 4);   //  4 代表晚餐
                intent.putExtra("store_no", i);           // i 午餐店編號;

                startActivity(intent);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,"back to last page: is clicked...");
                //Intent intent1 = new Intent(DinnerActivity.this, EatActivity.class);
                //startActivity(intent1);
                finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DinnerActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
