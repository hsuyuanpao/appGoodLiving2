package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

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

        ExpandableListView expandableListView = findViewById(R.id.expListview);
        List<String> headingList = new ArrayList<>();
        List<String> childList1 = new ArrayList<>();
        List<String> childList2 = new ArrayList<>();
        List<String> childList3 = new ArrayList<>();
        List<String> childList4 = new ArrayList<>();
        List<String> childList5 = new ArrayList<>();
        HashMap<String, List<String>> childLIst = new HashMap<String, List<String>>();

        String h[] = getResources().getStringArray(R.array.info_headings);
        String c1[] = getResources().getStringArray(R.array.h1_items);
        String c2[] = getResources().getStringArray(R.array.h2_items);
        String c3[] = getResources().getStringArray(R.array.h3_items);
        String c4[] = getResources().getStringArray(R.array.h4_items);
        String c5[] = getResources().getStringArray(R.array.h5_items);
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
