package com.hsuyuanpao.appgoodliving2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DisplayActivity";
    private int[] images = {R.drawable.temple, R.drawable.oldstreet, R.drawable.daughterbridge,
            R.drawable.cattlemarket, R.drawable.watertower, R.drawable.drawingcommunity,
            R.drawable.workshop, R.drawable.wudetemple, R.drawable.bridge, R.drawable.yimintemple, R.drawable.hodua,
            R.drawable.bookstore1_1, R.drawable.mazu_park1, R.drawable.sport_park_1, R.drawable.cultural_center,
            R.drawable.zhenan_temple1, R.drawable.backpack2_1};
    private int[] imMap = {R.drawable.temple_map, R.drawable.oldstreet_map, R.drawable.daughterbridge_map,
                        R.drawable.cattlemarket_map, R.drawable.watertower_map, R.drawable.drawingcommunity_map,
                        R.drawable.workshop_map, R.drawable.wudetemple_map, R.drawable.bridge_map, R.drawable.yimintemple_map,
                        R.drawable.hodua_map_1, R.drawable.bookstore_map_1, R.drawable.mazu_park_map_1, R.drawable.sport_park_map_1,
                        R.drawable.cultural_center_map_1, R.drawable.zhenan_temple_map_1, R.drawable.backpack_map_1};
    private int[] sounds = {R.raw.sound1, R.raw.sound2, R.raw.sound3, R.raw.sound4, R.raw.sound5, R.raw.sound6, R.raw.sound7,
                            R.raw.sound8, R.raw.s9, R.raw.s10, R.raw.s11, R.raw.s12, R.raw.s13, R.raw.s14,
                            R.raw.s15, R.raw.s16, R.raw.s17};

    ImageView imageView;
    ImageView imageView2;
    TextView  textView;
    TextView  textView2;
    ImageView playBtn;
    SeekBar     seekBar;
    MediaPlayer mediaPlayer;
    Runnable    runnable;
    Handler     handler;

    private List<String> listIG;
    private List<String> listFB;
    private static int i;
    private static int f = 0;
    private String igurl, fburl;
    private static String r_title;
    private static String desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Toolbar toolbar = findViewById(R.id.toolBar3);

        TextView tvTitle = findViewById(R.id.toolbarTitle);
        ImageView imTop1 = findViewById(R.id.imviewTop1);
        ImageView imTop2 = findViewById(R.id.imviewTop2);

        String title = getIntent().getStringExtra("image_title");
        if(title != null){//判斷是返回，還是新點選的景點。如果是返回則title和desc會是空的!
            r_title = title;

            desc = getIntent().getStringExtra("image_description");
        }
        //Toast.makeText(this, "title = "+r_title, Toast.LENGTH_SHORT).show();;
        i = getIntent().getIntExtra("image",0);
        tvTitle.setText(r_title);   // set toolbar Title

        imageView = findViewById(R.id.imageDisplay);
        imageView2 = findViewById(R.id.imageDisplay2);
        textView = findViewById(R.id.textTitle);
        textView2 = findViewById(R.id.textDesc);

        playBtn = findViewById(R.id.playBtn);
        handler = new Handler();
        seekBar = findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create(this, sounds[i]);

        listIG = Arrays.asList(getResources().getStringArray(R.array.attraction_igurl));
        listFB = Arrays.asList(getResources().getStringArray(R.array.attraction_fburl));


        textView.setText(r_title);
        Log.d(TAG,"onCreate : get image title...");
        //i = getIntent().getIntExtra("image",0);
        textView2.setText(desc);
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());

        //i = getIntent().getIntExtra("image",0);

        imageView.setBackgroundResource(images[i]);
        imageView2.setImageResource(imMap[i]);
        igurl = listIG.get(i);  //取得ig網址
        fburl = listFB.get(i);  //取得fb網址
        Log.d(TAG,"onCreate : get igurl..."+ igurl);
        //Toast.makeText(this, "image no. = "+ i, Toast.LENGTH_SHORT).show();

        imTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true); // change background color when clicked
                if(mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                handler.removeCallbacksAndMessages(null);
                //mediaPlayer.release();
                //mediaPlayer = null;
                finish();
            }
        });

        imTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                handler.removeCallbacksAndMessages(null);
                //mediaPlayer.release();
                //mediaPlayer = null;
                view.setSelected(true); // change background color when clicked
                Intent intent2 = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });

        playBtn.setOnClickListener(this);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
               //mediaPlayer.start();
                changeSeekbar();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                handler.removeCallbacksAndMessages(null);
                playBtn.setImageResource(R.drawable.play_1);
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                }
                //changeSeekbar();
                seekBar.setProgress(0);
                Log.d(TAG,"onCompletionListener is running...");
                //Toast.makeText(DisplayActivity.this, "MediaPlayer stopped", Toast.LENGTH_SHORT).show();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void changeSeekbar() {
        if(mediaPlayer.getDuration() == mediaPlayer.getCurrentPosition())
            seekBar.setProgress(0);
        else
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
        Log.d(TAG,"changeSeekbar is running");
        if(mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable,200);//一秒執行一次run()
        }
    }

    public void GoToMapsActivity(View view) {
        Log.d(TAG,"MapsActivity: is preparing to run...");
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            handler.removeCallbacksAndMessages(null);
            playBtn.setImageResource(R.drawable.play_1);
            Log.d(TAG,"mediaPlayer is paused");
            //Toast.makeText(this, "MediaPlayer paused", Toast.LENGTH_SHORT).show();
        }
        view.setSelected(true); // change background color when clicked
        Intent intent = new Intent(this, Maps2Activity.class);
        intent.putExtra("attraction_no", i);    //傳景點編號
        intent.putExtra("name", r_title);   //傳景點名稱
        startActivity(intent);
    }

    public void GoToIGActivity(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            handler.removeCallbacksAndMessages(null);
            playBtn.setImageResource(R.drawable.play_1);
            Log.d(TAG,"mediaPlayer is paused");
            //Toast.makeText(this, "MediaPlayer paused", Toast.LENGTH_SHORT).show();
        }
        Log.d(TAG,"IGActivity: is preparing to run...");
        view.setSelected(true); // change background color when clicked
        Intent intent = new Intent(this, IGActivity.class);
        intent.putExtra("urlString",igurl);
        intent.putExtra("title",r_title);
        startActivity(intent);
    }

    public void GoToFBActivity(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            handler.removeCallbacksAndMessages(null);
            playBtn.setImageResource(R.drawable.play_1);
            Log.d(TAG,"mediaPlayer is paused");
            //Toast.makeText(this, "MediaPlayer paused", Toast.LENGTH_SHORT).show();
        }
        Log.d(TAG,"FGActivity: is preparing to run...");
        view.setSelected(true); // change background color when clicked
        Intent intent = new Intent(this, FBActivity.class);
        intent.putExtra("urlString",fburl);
        intent.putExtra("title",r_title);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            handler.removeCallbacksAndMessages(null);
            playBtn.setImageResource(R.drawable.play_1);
            Log.d(TAG,"mediaPlayer is paused");
            //Toast.makeText(this, "MediaPlayer paused", Toast.LENGTH_SHORT).show();
        }
        else {
            mediaPlayer.start();
            playBtn.setImageResource(R.drawable.pause_1);
            changeSeekbar();
            Log.d(TAG,"mediaPlayer is starting");
            //Toast.makeText(this, "MediaPlayer playing", Toast.LENGTH_SHORT).show();
        }
    }
}

