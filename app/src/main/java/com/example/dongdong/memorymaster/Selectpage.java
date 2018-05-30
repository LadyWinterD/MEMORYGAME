package com.example.dongdong.memorymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selectpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectpage);
        Button Level2 =(Button) findViewById(R.id.Level2);
        Button Level3 =(Button) findViewById(R.id.Level3);
        Button Level4 =(Button) findViewById(R.id.Level4);
        Button Level5 =(Button) findViewById(R.id.Level5);
        Button Level6 =(Button) findViewById(R.id.Level6);

        if (GameResult.Level >= 2) {
            Level2.setEnabled(true);

        } else {
            Level2.setEnabled(false);

        }

        if (GameResult.Level >= 3) {
            GameResult.Level=3;
        } else {
            Level3.setEnabled(false);

        }
        if (GameResult.Level >= 4) {
            Level4.setEnabled(true);
            GameResult.Level=4;
        } else {
            Level4.setEnabled(false);

        }
        if (GameResult.Level >= 5) {
            Level5.setEnabled(true);
        } else {
            Level5.setEnabled(false);

        }
        if (GameResult.Level >= 6) {
            Level6.setEnabled(true);
        } else {
            Level6.setEnabled(false);

        }
    }

    public void Play(View view){
        Intent intent = new Intent(this,Tutorial.class);
        startActivity(intent);
        finish();
    }
    public void GoMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Play2(View view){
        Intent intent = new Intent(this,Level.class);
        startActivity(intent);
        GameResult.Level=2;
        finish();
    }
    public void Play3(View view){
        Intent intent = new Intent(this,Level.class);
        startActivity(intent);
        GameResult.Level=3;
        finish();
    }    public void Play4(View view){
        Intent intent = new Intent(this,Level.class);
        startActivity(intent);
        GameResult.Level=4;
        finish();
    }    public void Play5(View view){
        Intent intent = new Intent(this,Level.class);
        startActivity(intent);
        GameResult.Level=5;
        finish();
    }    public void Play6(View view){
        Intent intent = new Intent(this,Level.class);
        startActivity(intent);
        GameResult.Level=6;
        finish();
    }
}