package com.hsuyuanpao.appgoodliving2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomListAdapter3  extends ArrayAdapter<String>{

    private static final String TAG = "CustomListAdapter3";
    private Activity context;
    private ArrayList<String> list_title;
    private ArrayList<String> list_description;
   // ArrayList<String> list_image = new ArrayList<>();

    private int[] img = {R.drawable.temple, R.drawable.oldstreet, R.drawable.daughterbridge,
                    R.drawable.cattlemarket, R.drawable.watertower, R.drawable.drawingcommunity,
                    R.drawable.workshop, R.drawable.wudetemple, R.drawable.bridge, R.drawable.yimintemple,
                    R.drawable.hodua, R.drawable.bookstore1_1, R.drawable.mazu_park1, R.drawable.sport_park_1,
                    R.drawable.cultural_center, R.drawable.zhenan_temple1};

    static class ViewHolder{
        TextView title;
        TextView description;
        ImageView image;
        ImageView arrow;
        //int position;
    }

    public CustomListAdapter3(Activity context, ArrayList<String> list_title,
                              ArrayList<String> list_description){
        super(context, R.layout.activity_attractions_nearbycv, list_title);
        this.context = context;
        this.list_title = list_title;
        this.list_description = list_description;
       // this.list_image = list_image;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if(view == null){
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.activity_attractions_nearbycv,parent,false);
            holder.title = view.findViewById(R.id.cardTitle);
            holder.description = view.findViewById(R.id.cardDescription);
            holder.image = view.findViewById(R.id.cardImage);
            holder.arrow = view.findViewById(R.id.right_arrow);
            view.setTag(holder);

        }
        else{
            holder = (ViewHolder) view.getTag();

        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,"onClick: try to send image..."+ position);
                // Toast.makeText(context, cd.getTitle(), Toast.LENGTH_SHORT).show();
               /* if(position == 0){
                    Intent intent1 = new Intent(context, MatsuActivity.class);
                    intent1.putExtra("image_title", list_title.get(position));
                    context.startActivity(intent1);
                }
                else {*/
                    Intent intent = new Intent(context, DisplayActivity.class);
                    intent.putExtra("image_title", list_title.get(position));
                    intent.putExtra("image_description", list_description.get(position));
                    intent.putExtra("image", position);

                    context.startActivity(intent);
              //  }
            }
        });

        try{
            holder.title.setText(list_title.get(position));
            holder.description.setText(list_description.get(position));

            Log.d(TAG,"getViewer: try to display image..."+ position);

            Glide.with(context)
                    .load(img[position])
                    .into(holder.image);

            Glide.with(context)
                    .load(R.drawable.right_arrow8)
                    .into(holder.arrow);


        }
        catch(Exception e){
            Log.d(TAG,"getViewer: could not display image..." +position);
        }

        return view;
    }

}

