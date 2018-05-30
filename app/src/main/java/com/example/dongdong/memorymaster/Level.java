package com.example.dongdong.memorymaster;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Level extends AppCompatActivity {
    private int customerNum = 0;
    int leftMargin = 0;
    int topMargin = 0;
    private Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);



        RelativeLayout mylayout = new RelativeLayout(this);

        mylayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.levelbackground));


        final int[] images = {
                R.drawable.i1, R.drawable.i2, R.drawable.i3,
                R.drawable.i4};

        customerNum = 0;
        leftMargin = 0;
        topMargin = 0;

        Random generator = new Random();
        GameResult.result = "";
        for (int i = 1; i <= GameResult.Level; i++) {
            ImageView img = new ImageView(this);


            int rnum = generator.nextInt(4);
            GameResult.result = GameResult.result + rnum + ",";
            img.setImageResource(images[rnum]);
            RelativeLayout.LayoutParams imgDetail = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            leftMargin = 100 * customerNum;
            if (customerNum % 4 == 0) {
                topMargin = topMargin + 400;
                customerNum = 0;
            }
            imgDetail.setMargins(250 * customerNum, topMargin, 0, 0);
            imgDetail.width = 300;
            imgDetail.height = 400;
            customerNum = customerNum + 1;


            //LEFT . TOP. RIGHT. BOT
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
                        t.sleep(3000);
                        getnext();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            t.start();
        }
    public void getnext(){
        Intent intent = new Intent(Level.this, Leveldetail.class);
        startActivity(intent);
        finish();
    }




    }


