package com.example.dongdong.memorymaster;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Leveldetail extends AppCompatActivity {

    private int customerNum=0;
    private Thread t;
    final int[] images = {
            R.drawable.i1, R.drawable.i2, R.drawable.i3,
            R.drawable.i4};
    RelativeLayout mylayout;

    private Context context;
    int leftMargin=0;
    int topMargin=0;
    boolean isGotoNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mylayout = (RelativeLayout)findViewById(R.id.mylayout);
        context=this;
        GameResult.userResult="";
        customerNum=0;
        leftMargin=0;
        topMargin=0;
        isGotoNext=true;
        super.onCreate(savedInstanceState);

        //set the relativelayout of game area
        mylayout = new RelativeLayout(this);
        mylayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.leveldetailbackground));
        for(int i=0;i<4;i++){
            ImageView img=new ImageView(this);
            img.setImageResource(images[i]);
            RelativeLayout.LayoutParams imgDetail = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            imgDetail.setMargins(i*250,1300,0,0);
            imgDetail.width=300;
            imgDetail.height=400;

            //LEFT . TOP. RIGHT. BOT
            img.setTag(i);
            img.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    addResult((Integer)v.getTag());

                }
            });

            TextView LevelText = new TextView(this);  //level detail




            LevelText.setText("Level" + GameResult.Level);
            LevelText.setTextSize(30);
            LevelText.setGravity(Gravity.CENTER);



            mylayout.addView(img, imgDetail);
            mylayout.addView(LevelText);



        }
        setContentView(mylayout);
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.sleep(GameResult.Level*3000);
                    getnext();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }
    public void getnext(){
        if(isGotoNext) {
            GameResult.Level = GameResult.Level + 1;
            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
        }
    }


    public void addResult(int num){
        GameResult.userResult=GameResult.userResult+num+",";
        ImageView img=new ImageView(this);
        img.setImageResource(images[num]);
        RelativeLayout.LayoutParams imgDetail = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        leftMargin=100*customerNum;
        if(customerNum%4==0){
            topMargin=topMargin+400;
            customerNum=0;
        }
        imgDetail.setMargins(250*customerNum,topMargin,0,0);
        //LEFT . TOP. RIGHT. BOT
        imgDetail.width=300;
        imgDetail.height=400;
        mylayout.addView(img, imgDetail);
        setContentView(mylayout);
        customerNum=customerNum+1;

        if(customerNum==GameResult.Level){
            isGotoNext=false;
            GameResult.Level = GameResult.Level + 1;
            Intent intent = new Intent(this,Result.class);
            startActivity(intent);
        }
    }



}
