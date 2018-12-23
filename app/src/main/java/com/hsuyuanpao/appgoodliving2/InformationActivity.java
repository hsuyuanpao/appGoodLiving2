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
        final ArrayList address = new ArrayList<>();
        final ArrayList phone = new ArrayList();

        names.add("1.       朝天宮       >>");
        names.add("2.       武德宮       >>");
        names.add("3.     北港圖書館     >>");
        names.add("4.    北港文化中心    >>");
        names.add("5.      建國中學      >>");
        names.add("6.      北港高中      >>");
        names.add("7.      北港國中      >>");
        names.add("8.     港媽祖醫院     >>");
        names.add("9. 北港鎮公所免費停車場 >>");
        names.add("10.    北港遊客中心    >>");
        names.add("11.  全家(北港天后店)  >>");
        names.add("12.  7-11(朝天宮門市)  >>");
        names.add("13.   台西客運北港站   >>");
        names.add("14.   統聯客運北港站   >>");
        names.add("15.   嘉義客運北港站   >>");
        names.add("16.      164 縣道      >>");
        names.add("17.      145 縣道      >>");
        names.add("18.      159 縣道      >>");
        names.add("19.   高鐵接駁車資訊   >>");
        names.add("20. 媽祖醫院免費接駁車 >>");

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
        name_only.add("全家(北港天后店)");
        name_only.add("7-11(朝天宮門市)");
        name_only.add("台西客運北港站");
        name_only.add("統聯客運北港站");
        name_only.add("嘉義客運北港站");
        name_only.add("164 縣道");
        name_only.add("145 縣道");
        name_only.add("159 縣道");
        name_only.add("高鐵接駁車資訊");
        name_only.add("媽祖醫院免費接駁資訊");

        address.add("651雲林縣北港鎮中山路178號");
        address.add("651雲林縣北港鎮華勝路330號");
        address.add("651雲林縣北港鎮北辰路2-5號");
        address.add("651雲林縣北港鎮公園路66號");
        address.add("651雲林縣北港鎮大同路468號");
        address.add("651雲林縣北港鎮成功路26號");
        address.add("651雲林縣北港鎮民生路102號");
        address.add("651雲林縣北港鎮新德路123號");
        address.add("651雲林縣北港鎮文昌路78號");
        address.add("651雲林縣北港鎮民生路1號");
        address.add("651雲林縣北港鎮中山路90號");
        address.add("651雲林縣北港鎮中山路150號");
        address.add("651雲林縣北港鎮中正路119號");
        address.add("651雲林縣北港鎮中正路127號");
        address.add("651雲林縣北港鎮文化路89號");
        address.add("");
        address.add("");
        address.add("");
        address.add("651雲林縣北港鎮文化路89號");
        address.add("651雲林縣北港鎮新德路123號");

        phone.add("05 783 2055");
        phone.add("05 782 1445");
        phone.add("05 782 2836");
        phone.add("05 783 2999");
        phone.add("05 783 2724");
        phone.add("05 783 2022");
        phone.add("05 783 2022");
        phone.add("05 783 7901");
        phone.add("");
        phone.add("05 783 7427(免費腳踏車租用)");
        phone.add("05 783 7465");
        phone.add("05 782 4873");
        phone.add("05 782 0574");
        phone.add("05 782 0574");
        phone.add("05 783 2135");
        phone.add("");
        phone.add("");
        phone.add("");
        phone.add("05 783 2135");
        phone.add("05 783 7901 轉 8858");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_information_layout, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {// i 早餐店編號; 1 代表早餐
                //Log.d(TAG, "onItemClick: name: " + names.get(i));
                //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_SHORT).show();
                if (i == 18 || i == 19) {
                    Intent intent1 = new Intent(InformationActivity.this, DisplayInformation2Activity.class);
                    //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                    //Log.d(TAG, "onItemClick: name: " + names.get(i) + "no:" + i);
                    intent1.putExtra("name", name_only.get(i).toString());
                    intent1.putExtra("address", address.get(i).toString());
                    intent1.putExtra("phone", phone.get(i).toString());
                    intent1.putExtra("no", i); //傳編號
                    startActivity(intent1);
                }
                else {
                    Intent intent2 = new Intent(InformationActivity.this, DisplayInformationActivity.class);
                    //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                    //Log.d(TAG, "onItemClick: name: " + names.get(i) + "no:" + i);
                    intent2.putExtra("name", name_only.get(i).toString());
                    intent2.putExtra("address", address.get(i).toString());
                    intent2.putExtra("phone", phone.get(i).toString());
                    intent2.putExtra("no", i); //傳編號
                    startActivity(intent2);
                }
            }
        });
    }

    public void LastPage(View view){
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }

    public void HomePage(View view){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}
