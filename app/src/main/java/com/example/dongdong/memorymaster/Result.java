package com.example.dongdong.memorymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {
    private Button restart;
    private Button next;
    boolean pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView te=(TextView) findViewById(R.id.resultText);
        Button next =(Button) findViewById(R.id.next);
        Button restart =(Button) findViewById(R.id.restart);

        String result="Good Job! Go to Next Level!";
        if(!GameResult.result.equals(GameResult.userResult)) {
            result = "game over";
            next.setVisibility(View.GONE);
        }else{
            restart.setVisibility(View.GONE);
        }



        te.setText(result);
    }
    public void Restart(View view){
        Intent intent = new Intent(Result.this, Level.class);
        GameResult.Level=GameResult.Level-1;
        startActivity(intent);
        finish();
    }
    public void next(View view){
        Intent intent = new Intent(Result.this, Level.class);
        startActivity(intent);
        finish();
    }
    public void Select(View view){
        Intent intent = new Intent(Result.this, Selectpage.class);
        startActivity(intent);
        finish();
    }

}