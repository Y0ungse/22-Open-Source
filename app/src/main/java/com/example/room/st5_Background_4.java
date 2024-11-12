package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st5_Background_4 extends AppCompatActivity {
    private Button st5_btn_movetv, st5_btn_lock_2, st5_btn_pattern_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_background4);


        st5_btn_movetv = findViewById(R.id.st5_btn_movetv);
        st5_btn_movetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_Background_4.this, st5_Background_5.class); //Background5 화면으로 인텐트
                startActivity(intent);
            }
        });

        st5_btn_lock_2 = findViewById(R.id.st5_btn_lock2);
        st5_btn_lock_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TV가 켜져있는 것 같은데 TV를 살펴볼까?", Toast.LENGTH_LONG).show(); //lock2 클릭시 토스트
                Intent intent = new Intent(st5_Background_4.this, st5_lock_2.class); //lock2 화면으로 인텐트
                startActivity(intent);
            }
        });

        st5_btn_pattern_lock = findViewById(R.id.st5_btn_pattern_lock);
        st5_btn_pattern_lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "탈출하기 위해서는 패턴이 필요한 것 같아", Toast.LENGTH_SHORT).show(); //lock3 클릭시
                Intent intent = new Intent(st5_Background_4.this, st5_lock_3.class); //lock 화면으로 인텐트
                startActivity(intent);
            }
        });
    }
}