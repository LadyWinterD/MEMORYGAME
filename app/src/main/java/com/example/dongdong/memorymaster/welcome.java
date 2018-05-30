package com.example.dongdong.memorymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class welcome extends AppCompatActivity {
private Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    }


