package com.example.gameplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity2 extends AppCompatActivity {
    private TextView txtScore1;
    private RadioGroup Radio_ans1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        Intent caller=getIntent();
        final int[] score = {caller.getIntExtra("Score", 0)};

        txtScore1 = findViewById(R.id.txtScore1);
        txtScore1.setText("Score : "+ score[0]);

        Radio_ans1= findViewById(R.id.radioGroup11);
        Radio_ans1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton11)
                {
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_LONG).show();
                }
                else if (checkedId==R.id.radioButton21)
                {
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_LONG).show();
                }
                else if (checkedId==R.id.radioButton31)
                {

                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                    score[0]++;
                    txtScore1.setText("Score : "+ score[0]);

                }
            }
        });

        Button btnNext= findViewById(R.id.button11);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent();
                nxt.setClass(getApplicationContext(),QuizActivity3.class);
                nxt.putExtra("Score", score[0]);
                startActivity(nxt);
            }
        });

        Button btn_main = findViewById(R.id.button21);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent();
                nxt.setClass(getApplicationContext(),MainActivity.class);
                startActivity(nxt);
            }
        });

    }


}