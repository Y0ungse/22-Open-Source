package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class main2_4 extends AppCompatActivity {
    private Button stage1, stage2, stage3, stage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        stage1 = findViewById(R.id.stage1);
        stage2 = findViewById(R.id.stage2);
        stage3 = findViewById(R.id.stage3);
        stage4 = findViewById(R.id.stage4);

        stage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "더이상 갈 필요가 없어", Toast.LENGTH_SHORT).show(); //stage1 클릭시 이미 클리어한 스테이지임을 토스트
            }
        });
        stage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "더이상 갈 필요가 없어", Toast.LENGTH_SHORT).show(); //stage2 클릭시 이미 클리어한 스테이지임을 토스트
            }
        });
        stage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "더이상 갈 필요가 없어", Toast.LENGTH_SHORT).show(); //stage3 클릭시 이미 클리어한 스테이지임을 토스트
            }
        });
        stage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main2_4.this, st4_StartAndEnding_HowToPlay.class);
                startActivity(intent);
            }
        });
    }
}