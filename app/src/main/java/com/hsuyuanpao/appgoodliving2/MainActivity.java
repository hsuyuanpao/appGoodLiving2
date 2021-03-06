package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private ImageView imageView;
  //  private Handler handler = new Handler();
  //  private Runnable runnable;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate: is running...");

        if (i == 0){    //第一次才秀出logo，其他為返回，不秀logo，以免感覺不佳
            Intent intent = new Intent(this, ShowLogoActivity.class);
            startActivity(intent);
            i++;
            //Toast.makeText(this,"i = "+i, Toast.LENGTH_SHORT).show();
        }
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Log.d(TAG,"onCreate: showing home icon...");
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        TextView tv = findViewById(R.id.mytv);
        tv.setSelected(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nvView);

        imageView = findViewById(R.id.imView1);
        imageView.setBackgroundResource(R.drawable.hodua1);

        LinearLayout linearLayout1 = findViewById(R.id.lnmain1);
        LinearLayout linearLayout2 = findViewById(R.id.lnmain2);
        LinearLayout linearLayout3 = findViewById(R.id.lnmain3);
        LinearLayout linearLayout4 = findViewById(R.id.lnmain4);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //景點介紹
                view.setSelected(true);
                Intent intent6 = new Intent(MainActivity.this, AttrcationsNearByCVActivity.class);
                startActivity(intent6);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //吃喝推薦
                view.setSelected(true);
                Intent intent7 = new Intent(MainActivity.this, EatActivity.class);
                startActivity(intent7);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //前往好住
                view.setSelected(true);
                Intent intent8 = new Intent(MainActivity.this, GoToGoodLivingActivity.class);
                startActivity(intent8);
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //報馬仔
                view.setSelected(true);
                Intent intent9 = new Intent(MainActivity.this, Information2Activity.class);
                startActivity(intent9);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_attractions:
                        menuItem.setChecked(true);
                      //  Log.d(TAG,"onCreate: item is selected...");
                      //  displayMessage("週邊景點介紹");
                        drawerLayout.closeDrawers();
                        Intent intent1 = new Intent(MainActivity.this, AttrcationsNearByCVActivity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.nav_hodua:
                        menuItem.setChecked(true);
                        //displayMessage("前往好住網頁");
                        drawerLayout.closeDrawers();
                        Intent intent2 = new Intent(MainActivity.this,GoToGoodLivingActivity.class);
                        startActivity(intent2);
                        return true;
                 /*   case R.id.nav_qrcode:
                        menuItem.setChecked(true);
                        //displayMessage("qrcode掃描");
                        drawerLayout.closeDrawers();
                        Intent intent3 = new Intent(MainActivity.this, QRCodeScanActivity.class);
                        startActivity(intent3);
                        return true;*/
                    case R.id.nav_recommendation:
                        menuItem.setChecked(true);
                       //displayMessage("吃吃喝喝推薦");
                        drawerLayout.closeDrawers();
                        Intent intent4 = new Intent(MainActivity.this, EatActivity.class);
                        Log.d(TAG,"MapsActivity: is preparing to run...");
                        startActivity(intent4);
                        return true;
                    case R.id.nav_traffic_information:
                        menuItem.setChecked(true);
                       // displayMessage("交通資訊報馬仔");
                        drawerLayout.closeDrawers();
                        Intent intent5 = new Intent(MainActivity.this, Information2Activity.class);
                        Log.d(TAG,"MapsActivity: is preparing to run...");
                        startActivity(intent5);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
                return super.onOptionsItemSelected(item);
    }

    /*private void displayMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void GoToAttractions(View view){
        Intent intent6 = new Intent(this, AttrcationsNearByCVActivity.class);
        startActivity(intent6);

    }

    public void GoToEat(View view){
        Intent intent7 = new Intent(this, EatActivity.class);
        startActivity(intent7);

    }

    public void GoToHodua(View view){
        Intent intent8 = new Intent(this, GoToGoodLivingActivity.class);
        startActivity(intent8);
    }

    public void GoToInformation(View view){
        Intent intent9 = new Intent(this, InformationActivity.class);
        startActivity(intent9);
    }*/

}
