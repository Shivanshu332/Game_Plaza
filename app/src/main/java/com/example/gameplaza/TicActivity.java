package com.example.gameplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicActivity extends AppCompatActivity implements View.OnClickListener {
    private int roundCount=0;

    private boolean p1_Turn=true;

    private Button[][] buttons = new Button[3][3];

    private TextView txt_p1;
    private TextView txt_p2;

    private int p1_points=0;
    private int p2_points=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic);
        txt_p1 = findViewById(R.id.txt_p1);
        txt_p2 = findViewById(R.id.txt_p2);


        Button btnReset = findViewById(R.id.btn_Reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_p1.setText("Player 1: 0");
                txt_p2.setText("Player 2: 0");
            }
        });

        Button btn_Back = findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent();
                back.setClass(getApplicationContext(),MainActivity.class);
                startActivity(back);
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "btn_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    public void onClick(View v)
    {
        if (!((Button) v).getText().toString().equals(""))
        {
            return;
        }
        if (p1_Turn)
        {
            ((Button) v).setText("X");
        }
        else
        {
            ((Button) v).setText("O");
        }
        roundCount++;
        if(CheckforWin())
        {
            if (p1_Turn)
            {
                p1_Wins();
            }
            else
            {
                p2_Wins();
            }
        }
        else if (roundCount == 9) {
            draw();
        } else {
            p1_Turn = !p1_Turn;
        }
    }
    private boolean CheckforWin()
    {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }
    private void p1_Wins()
    {
        p1_points++;
        Toast.makeText(getApplicationContext(),"Player 1 Wins",Toast.LENGTH_LONG).show();
        updatePts();
        resetBoard();
    }
    private void p2_Wins()
    {
        p2_points++;
        Toast.makeText(getApplicationContext(),"Player 2 Wins",Toast.LENGTH_LONG).show();
        updatePts();
        resetBoard();
    }
    private void draw()
    {
        Toast.makeText(getApplicationContext(),"Draw!!! No one wins ",Toast.LENGTH_LONG).show();
        resetBoard();
    }
    private void updatePts()
    {
        txt_p1.setText("Player 1 : "+p1_points);
        txt_p2.setText("Player 2 : "+p2_points);
    }
    private void resetBoard()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        p1_Turn = true;
    }
}