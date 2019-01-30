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

public class LunchActivity extends AppCompatActivity {
    private static final String TAG = "LunchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        Toolbar toolbar = findViewById(R.id.toolBarLunch);
        TextView textView = findViewById(R.id.toolbarTitle);
        ImageView imageView1 = findViewById(R.id.imviewTop1);
        ImageView imageView2 = findViewById(R.id.imviewTop2);
        textView.setText("午餐推薦");

        ListView list = findViewById(R.id.listLunch);
        Log.d(TAG, "onCreate: Started.");

        final ArrayList names = new ArrayList<>();
        final ArrayList addresses = new ArrayList();
        final ArrayList phones = new ArrayList();
        final ArrayList name_only = new ArrayList();

        names.add("1.　阿等土豆油飯　　>>");
        names.add("2.　李記生炒鴨肉羹　>>");
        names.add("3.　加運包子店　　　>>");
        names.add("4.　九久醇義麵坊　　>>");
        names.add("5.　老受鴨肉飯　　　>>");
        names.add("6.　福安鴨肉飯　　　>>");
        names.add("7.　青松餐廳　　　　>>");
        names.add("8.　吉輝餐廳　　　　>>");

        addresses.add("地址: 651雲林縣北港鎮大同路79號");
        addresses.add("地址: 651雲林縣北港鎮公民路42號");
        addresses.add("地址: 651雲林縣北港鎮光明路20號");
        addresses.add("地址: 651雲林縣北港鎮公民路37號");
        addresses.add("地址: 651雲林縣北港鎮中山路104號");
        addresses.add("地址: 651雲林縣北港鎮中山路37號");
        addresses.add("地址: 651雲林縣北港鎮太平路369號");
        addresses.add("地址: 651雲林縣北港鎮文化路184號之1號");

        phones.add("電話: 05 773 1187");
        phones.add("電話: 05 783 9568");
        phones.add("電話: 05 783 2665");
        phones.add("電話: 05 782 6727");
        phones.add("電話: 05 783 0389");
        phones.add("電話: 0919 800 101");
        phones.add("電話: 05 783 6548");
        phones.add("電話: 05 782 2255");

        name_only.add("阿等土豆油飯");
        name_only.add("李記生炒鴨肉羹");
        name_only.add("加運包子店");
        name_only.add("九久醇義麵坊");
        name_only.add("老受鴨肉飯");
        name_only.add("福安鴨肉飯");
        name_only.add("青松餐廳");
        name_only.add("吉輝餐廳");


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_lunch_layout, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: name: " + names.get(i));
                // Toast.makeText(GoToBreakfastActivity.this, "You clicked on: " + names.get(i), Toast.LENGTH_SHORT).show();
                view.setSelected(true); // change background color when clicked
                Intent intent = new Intent(LunchActivity.this, DisplayStoreActivity.class);
                intent.putExtra("name", name_only.get(i).toString());
                intent.putExtra("address", addresses.get(i).toString());
                intent.putExtra("phone", phones.get(i).toString());
                intent.putExtra("meal_class", 2);   //  2 代表午餐
                intent.putExtra("store_no", i);           // i 午餐店編號;

                startActivity(intent);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,"back to last page: is clicked...");
                //Intent intent1 = new Intent(LunchActivity.this, EatActivity.class);
                //startActivity(intent1);
                finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LunchActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
