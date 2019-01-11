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

public class AfternoonteaActivity extends AppCompatActivity {
    private static final String TAG = "AfternoonteaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afternoontea);

        Toolbar toolbar = findViewById(R.id.toolBarAfternoontea);
        TextView textView = findViewById(R.id.toolbarTitle);
        ImageView imageView1 = findViewById(R.id.imviewTop1);
        ImageView imageView2 = findViewById(R.id.imviewTop2);
        textView.setText("下午茶推薦");

        ListView list = findViewById(R.id.listAfternoontea);
        Log.d(TAG, "onCreate: Started.");

        final ArrayList names = new ArrayList<>();
        final ArrayList addresses = new ArrayList();
        final ArrayList phones = new ArrayList();
        final ArrayList name_only = new ArrayList();

        names.add("1.　　　加運包子店　　　>>");
        names.add("2.　　-金牛古味刨冰-　　>>");
        names.add("3.　　　北港圓仔湯　　　>>");
        names.add("4.　　-秀山杏仁豆腐-　　>>");
        names.add("5.　北港秋田古早味果汁　>>");
        names.add("6.　　　粳粽林粽冰　　　>>");
        names.add("7.　　　　木瓜田　　　　>>");
        names.add("8.　　-陳氏姊妹果汁-　　>>");
        names.add("9.　　　-天后咖啡-　　　>>");
        names.add("10.　　-光明屋書店-　　>>");


        addresses.add("地址: 651雲林縣北港鎮光明路20號");
        addresses.add("地址: 651雲林縣北港鎮中山路14號");
        addresses.add("地址: 651雲林縣北港鎮中山路29號");
        addresses.add("地址: 651雲林縣北港鎮中山路77號");
        addresses.add("地址: 651雲林縣北港鎮博愛路72號");
        addresses.add("地址: 651雲林縣北港鎮中正路83號");
        addresses.add("地址:651雲林縣北港鎮文化路79號");
        addresses.add("地址: 651雲林縣北港鎮光明路51號");
        addresses.add("地址: 651雲林縣北港鎮博愛路89號");
        addresses.add("地址: 651雲林縣北港鎮光明路122號");

        phones.add("電話: 05 783 2665");
        phones.add("電話: 05 783 4503");
        phones.add("電話: 05 773 1231");
        phones.add("電話: 05 783 9838");
        phones.add("電話: 0932 694 333");
        phones.add("電話: 0935 760 618");
        phones.add("電話: 05 782 5250");
        phones.add("電話: 05 783 7665");
        phones.add("電話: 05 773 0236");
        phones.add("電話: 05 783 7556");

        name_only.add("加運包子店");
        name_only.add("金牛古味刨冰");
        name_only.add("北港圓仔湯");
        name_only.add("秀山杏仁豆腐");
        name_only.add("北港秋田古早味果汁");
        name_only.add("粳粽林粽冰");
        name_only.add("木瓜田");
        name_only.add("陳氏姊妹果汁");
        name_only.add("天后咖啡");
        name_only.add("光明屋書店");


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_afternoontea_layout, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: name: " + names.get(i));
                // Toast.makeText(GoToBreakfastActivity.this, "You clicked on: " + names.get(i), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AfternoonteaActivity.this, DisplayStoreActivity.class);
                intent.putExtra("name", name_only.get(i).toString());
                intent.putExtra("address", addresses.get(i).toString());
                intent.putExtra("phone", phones.get(i).toString());
                intent.putExtra("meal_class", 3);   //  3 代表下午茶
                intent.putExtra("store_no", i);           // i 午餐店編號;

                startActivity(intent);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,"back to last page: is clicked...");
                //Intent intent1 = new Intent(AfternoonteaActivity.this, EatActivity.class);
                //tartActivity(intent1);
                finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AfternoonteaActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
