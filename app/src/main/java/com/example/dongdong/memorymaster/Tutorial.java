package com.example.dongdong.memorymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tutorial extends AppCompatActivity {
private Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

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
        Intent intent = new Intent(this, Level.class);
        startActivity(intent);
        finish();
    }
    }

