package com.example.gameplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity1 extends AppCompatActivity {
    int score=0;
    private TextView txtScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        txtScore = findViewById(R.id.txtScore);

        RadioGroup Radio_ans= (RadioGroup) findViewById(R.id.radioGroup);
        Radio_ans.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton)
                {
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                    score++;
                    updatescore();
                }
                else if (checkedId==R.id.radioButton2)
                {
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_LONG).show();
                }
                else if (checkedId==R.id.radioButton3)
                {
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btnNext= findViewById(R.id.button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent();
                nxt.setClass(getApplicationContext(),QuizActivity2.class);
                nxt.putExtra("Score",score);
                startActivity(nxt);
            }
        });

        Button btn_main = findViewById(R.id.button2);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent();
                nxt.setClass(getApplicationContext(),MainActivity.class);
                startActivity(nxt);
            }
        });

    }

    private void updatescore()
    {
        txtScore.setText("Score : "+score);
    }
}