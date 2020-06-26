package com.example.gameplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity3 extends AppCompatActivity {
    private TextView txtScore22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        txtScore22 = findViewById(R.id.txtScore22);
        Intent caller=getIntent();
        final int[] score = {caller.getIntExtra("Score", 0)};

        txtScore22.setText("Score : "+ score[0]);

        RadioGroup Radio_ans= findViewById(R.id.radioGroup22);
        Radio_ans.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton22)
                {
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                    score[0]++;
                    txtScore22.setText("Score : "+ score[0]);
                }
                else if (checkedId==R.id.radioButton23)
                {
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_LONG).show();
                }
                else if (checkedId==R.id.radioButton32)
                {
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btn_main = findViewById(R.id.button22);
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