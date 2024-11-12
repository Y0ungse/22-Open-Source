package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st5_Background_5 extends AppCompatActivity {
    private Button st5_btn_tv, st5_btn_underdesk, st5_btn_cabinet, st5_btn_movingout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_background5);

        st5_btn_cabinet = findViewById(R.id.st5_btn_cabinet);
        st5_btn_cabinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "캐비넷에는 아무것도 없는 것 같다..", Toast.LENGTH_SHORT).show();
            }
        });

        st5_btn_movingout = findViewById(R.id.st5_btn_moving);
        st5_btn_movingout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st5_Background_5.this, st5_Background_4.class);
                startActivity(intent);
                finish();
            }
        });

        st5_btn_tv = findViewById(R.id.st5_btn_tv);
        st5_btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_Background_5.this, st5_quiz_2.class); //quiz2 화면으로 인텐트
                startActivity(intent);
            }
        });

        st5_btn_underdesk = findViewById(R.id.st5_btn_underdesk);
        st5_btn_underdesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_Background_5.this, st5_Background_6.class); //Background6 화면으로 인텐트
                startActivity(intent);
            }
        });
    }
}