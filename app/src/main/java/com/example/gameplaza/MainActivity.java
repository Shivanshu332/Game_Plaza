package com.example.gameplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTic = findViewById(R.id.btnTic);

        btnTic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tic_game= new Intent();
                tic_game.setClass(getApplicationContext(),TicActivity.class);
                startActivity(tic_game);
            }
        });

        Button btnQuiz = findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz_game=new Intent();
                quiz_game.setClass(getApplicationContext(),QuizActivity1.class);
                startActivity(quiz_game);
            }
        });



        Button btnRefer= findViewById(R.id.btnRefer);
        btnRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refer_sms= new Intent();
                refer_sms.setClass(getApplicationContext(),ReferActivity.class);
                startActivity(refer_sms);
            }
        });
    }
}