package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Information2Activity extends AppCompatActivity {
    private static final String TAG = "Info2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information2);
        Log.d(TAG,"onCreate: item is selected...");

        Toolbar toolbar = findViewById(R.id.toolbarTop);
        TextView textView = findViewById(R.id.toolbarTitle);
        textView.setText("交 通 資 訊 報 馬 仔");

        final ArrayList names = new ArrayList();
        final ArrayList name_only = new ArrayList();
        final ArrayList address = new ArrayList<>();
        final ArrayList phone = new ArrayList();

        names.add("1.       朝天宮       >>");
        names.add("2.       武德宮       >>");
        names.add("3.       北港彌陀寺       >>");
        names.add("4.       北港天理教會       >>");
        names.add("5.       北壇碧水寺       >>");
        names.add("6.       北港水仙宮       >>");
        names.add("7.       北港南潭水月庵       >>");
        names.add("8.       北港義民廟       >>");
        names.add("9.       北港鎮安宮       >>");
        names.add("10.       北港慈德禪寺       >>");
        names.add("11.       北港基督長老教會       >>");
        names.add("12.       北港昭烈宮       >>");
        names.add("13.       北港代天府       >>");
        names.add("14.       北港善牧天主堂       >>");

        names.add("15.     北港圖書館     >>");
        names.add("16.    北港文化中心    >>");
        names.add("17.      建國中學      >>");
        names.add("18.      北港高中      >>");
        names.add("19.      北港國中      >>");
        names.add("20. 北港鎮公所免費停車場 >>");
        names.add("21.    北港遊客中心    >>");

        names.add("22.  全家(北港天后店)  >>");
        names.add("23.  7-11(朝天宮門市)  >>");

        names.add("24.   台西客運北港站   >>");
        names.add("25.   統聯客運北港站   >>");
        names.add("26.   嘉義客運北港站   >>");
        names.add("27.      164 縣道      >>");
        names.add("28.      145 縣道      >>");
        names.add("29.      159 縣道      >>");
        names.add("30.   高鐵接駁車資訊   >>");
        names.add("31. 媽祖醫院免費接駁車 >>");

        names.add("32.     港媽祖醫院     >>");
        names.add("33         診所        >>");
        names.add("34         藥局        >>");


        name_only.add("朝天宮");
        name_only.add("武德宮");
        name_only.add("北港彌陀寺");
        name_only.add("北港天理教會");
        name_only.add("北壇碧水寺");
        name_only.add("北港水仙宮");
        name_only.add("北港南潭水月庵");
        name_only.add("北港義民廟");
        name_only.add("北港鎮安宮");
        name_only.add("北港慈德禪寺");
        name_only.add("北港基督長老教會");
        name_only.add("北港昭烈宮");
        name_only.add("北港代天府");
        name_only.add("北港善牧天主堂");

        name_only.add("北港圖書館");
        name_only.add("北港文化中心");
        name_only.add("建國中學");
        name_only.add("北港高中");
        name_only.add("北港國中");
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

        name_only.add("北港媽祖醫院");
        name_only.add("診所");
        name_only.add("藥局");


        address.add("651雲林縣北港鎮中山路178號");
        address.add("651雲林縣北港鎮華勝路330號");
        address.add("651雲林縣北港鎮中秋路94號");
        address.add("651雲林縣北港鎮中秋路1-2號");
        address.add("651雲林縣北港鎮新德路3號");
        address.add("616嘉義縣新港鄉南港村舊南港58號");
        address.add("616嘉義縣新港鄉頂菜園1號");
        address.add("651雲林縣北港鎮旌義街20號");
        address.add("651雲林縣北港鎮館前街22號");
        address.add("651雲林縣北港鎮光明路162號");
        address.add("651雲林縣北港鎮中正路94號");
        address.add("651雲林縣北港鎮公民路61號");
        address.add("651雲林縣北港鎮復興街20號");
        address.add("651雲林縣北港鎮民有路19號");



        address.add("651雲林縣北港鎮北辰路2-5號");
        address.add("651雲林縣北港鎮公園路66號");
        address.add("651雲林縣北港鎮大同路468號");
        address.add("651雲林縣北港鎮成功路26號");
        address.add("651雲林縣北港鎮民生路102號");
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

        address.add("651雲林縣北港鎮新德路123號");
        address.add("");
        address.add("");


        phone.add("05 783 2055");
        phone.add("05 782 1445");
        phone.add("05 783 3038");
        phone.add("05 783 4166");
        phone.add("05 783 3566");
        phone.add("05 781 1751");
        phone.add("05 781 1800");
        phone.add("05 783 8213");
        phone.add("05 783 7184");
        phone.add("05 783 6011");
        phone.add("");
        phone.add("05 782 1611");
        phone.add("05 783 1256");
        phone.add("05 783 4283");



        phone.add("05 782 2836");
        phone.add("05 783 2999");
        phone.add("05 783 2724");
        phone.add("05 783 2022");
        phone.add("05 783 2022");
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

        phone.add("05 783 7901");
        phone.add("");
        phone.add("");


        ExpandableListView expandableListView = findViewById(R.id.expListview);
        final List<String> headingList = new ArrayList<>();
        List<String> childList1 = new ArrayList<>();
        List<String> childList2 = new ArrayList<>();
        List<String> childList3 = new ArrayList<>();
        List<String> childList4 = new ArrayList<>();
        List<String> childList5 = new ArrayList<>();
        final HashMap<String, List<String>> childLIst = new HashMap<String, List<String>>();

        String h[] = getResources().getStringArray(R.array.info_headings);
        final String c1[] = getResources().getStringArray(R.array.h1_items);
        final String c2[] = getResources().getStringArray(R.array.h2_items);
        final String c3[] = getResources().getStringArray(R.array.h3_items);
        final String c4[] = getResources().getStringArray(R.array.h4_items);
        final String c5[] = getResources().getStringArray(R.array.h5_items);
        for(String title: h)
        {
            headingList.add(title);
        }
        for(String title: c1)
        {
            childList1.add(title);
        }
        for(String title: c2)
        {
            childList2.add(title);
        }
        for(String title: c3)
        {
            childList3.add(title);
        }
        for(String title: c4)
        {
            childList4.add(title);
        }
        for(String title: c5)
        {
            childList5.add(title);
        }

        childLIst.put(headingList.get(0), childList1);
        childLIst.put(headingList.get(1), childList2);
        childLIst.put(headingList.get(2), childList3);
        childLIst.put(headingList.get(3), childList4);
        childLIst.put(headingList.get(4), childList5);
        Information2Adapter information2Adapter = new Information2Adapter(this,headingList, childLIst);
        expandableListView.setAdapter(information2Adapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                //Toast.makeText(Information2Activity.this," You expand: " + headingList.get(i), Toast.LENGTH_LONG).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
               // Toast.makeText(Information2Activity.this," You expand: " + childLIst.get(headingList.get(i)).get(i1) +
               //         " from "+ headingList.get(i), Toast.LENGTH_LONG).show();
                switch (i)
                {
                    case 3: if(i1 == 6 || i1 == 7)
                    {
                        Intent intent3 = new Intent(Information2Activity.this, DisplayInformation2Activity.class);
                        //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                        //Log.d(TAG, "onChildClicked: name: " + names.get( c1.length+c2.length+c3.length+i1) + "no:" + c1.length+c2.length+c3.length+i1);
                        intent3.putExtra("name", name_only.get( c1.length+c2.length+c3.length+i1).toString());
                        intent3.putExtra("address", address.get( c1.length+c2.length+c3.length+i1).toString());
                        intent3.putExtra("phone", phone.get( c1.length+c2.length+c3.length+i1).toString());
                        intent3.putExtra("no", c1.length+c2.length+c3.length+i1); //傳編號
                        startActivity(intent3);
                    }
                    else
                    {
                        Intent intent3 = new Intent(Information2Activity.this, DisplayInformationActivity.class);
                        //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                        Log.d(TAG, "onChildClicked: name: " + names.get( c1.length+c2.length+c3.length+i1) + "no:" + c1.length+c2.length+c3.length+i1);
                        intent3.putExtra("name", name_only.get( c1.length+c2.length+c3.length+i1).toString());
                        intent3.putExtra("address", address.get( c1.length+c2.length+c3.length+i1).toString());
                        intent3.putExtra("phone", phone.get( c1.length+c2.length+c3.length+i1).toString());
                        intent3.putExtra("no", c1.length+c2.length+c3.length+i1); //傳編號
                        startActivity(intent3);
                    }
                    return true;

                    case 0:
                    {
                        Intent intent0 = new Intent(Information2Activity.this, DisplayInformationActivity.class);
                        //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                        //Log.d(TAG, "onItemClick: name: " + names.get(i) + "no:" + i);
                        intent0.putExtra("name", name_only.get(i1).toString());
                        intent0.putExtra("address", address.get(i1).toString());
                        intent0.putExtra("phone", phone.get(i1).toString());
                        intent0.putExtra("no", i1); //傳編號
                        startActivity(intent0);
                    }
                    return true;

                    case 1:
                    {
                        Intent intent1 = new Intent(Information2Activity.this, DisplayInformationActivity.class);
                        //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                        //Log.d(TAG, "onItemClick: name: " + names.get(i) + "no:" + i);
                        intent1.putExtra("name", name_only.get(c1.length+i1).toString());
                        intent1.putExtra("address", address.get(c1.length+i1).toString());
                        intent1.putExtra("phone", phone.get(c1.length+i1).toString());
                        intent1.putExtra("no", c1.length+i1); //傳編號
                        startActivity(intent1);
                    }
                    return true;

                    case 2:
                    {
                        Intent intent2 = new Intent(Information2Activity.this, DisplayInformationActivity.class);
                        //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                        //Log.d(TAG, "onItemClick: name: " + names.get(i) + "no:" + i);
                        intent2.putExtra("name", name_only.get(c1.length+c2.length+i1).toString());
                        intent2.putExtra("address", address.get(c1.length+c2.length+i1).toString());
                        intent2.putExtra("phone", phone.get(c1.length+c2.length+i1).toString());
                        intent2.putExtra("no", c1.length+c2.length+i1); //傳編號
                        startActivity(intent2);
                    }
                    return true;

                    case 4:
                    {
                        if(i1 == 0)
                        {
                            Intent intent4 = new Intent(Information2Activity.this, DisplayInformationActivity.class);
                            //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                            Log.d(TAG, "onChildClicked: name: " + names.get(c1.length + c2.length + c3.length + c4.length + i1) + "no:" + c1.length + c2.length + c3.length + c4.length + i1);
                            intent4.putExtra("name", name_only.get(c1.length + c2.length + c3.length + c4.length + i1).toString());
                            intent4.putExtra("address", address.get(c1.length + c2.length + c3.length + c4.length + i1).toString());
                            intent4.putExtra("phone", phone.get(c1.length + c2.length + c3.length + c4.length + i1).toString());
                            intent4.putExtra("no", c1.length + c2.length + c3.length + c4.length + i1 - 2); //傳編號，扣掉兩個無經緯度的項目
                            startActivity(intent4);
                        }
                        else
                        {
                            Intent intent4 = new Intent(Information2Activity.this, Information2Webpage.class);
                            //Toast.makeText(InformationActivity.this, "You clicked on: " + name_only.get(i), Toast.LENGTH_LONG).show();
                            Log.d(TAG, "onChildClicked: name: " + names.get(c1.length + c2.length + c3.length + c4.length + i1) + "no:" + c1.length + c2.length + c3.length + c4.length + i1);
                            intent4.putExtra("name", name_only.get(c1.length + c2.length + c3.length + c4.length + i1).toString());
                            intent4.putExtra("address", address.get(c1.length + c2.length + c3.length + c4.length + i1).toString());
                            intent4.putExtra("phone", phone.get(c1.length + c2.length + c3.length + c4.length + i1).toString());
                            intent4.putExtra("no", c1.length + c2.length + c3.length + c4.length + i1); //傳編號，含無經緯度的項目
                            startActivity(intent4);
                        }
                    }
                    return true;

                }

                return false;
            }
        });
    }

    public void LastPage(View view){
        //Intent intent3 = new Intent(this, MainActivity.class);
        //startActivity(intent3);
        finish();
    }

    public void HomePage(View view){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}
