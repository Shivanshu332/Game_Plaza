package com.example.gameplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer);
        final EditText txtNum= findViewById(R.id.txtNum);
        Button btnSend= findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="This is very intersting app developed by Shivanshu Download it immidiately";
                String num=txtNum.getText().toString();
                Uri destination= Uri.parse("smsto:"+num);
                Intent sms=new Intent(Intent.ACTION_SENDTO, destination);
                sms.putExtra("sms_body",message);
                startActivity(sms);
            }
        });

        Button btnback= findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back =new Intent();
                back.setClass(getApplicationContext(),MainActivity.class);
                startActivity(back);
            }
        });
    }
}