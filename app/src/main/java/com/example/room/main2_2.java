package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class main2_2 extends AppCompatActivity {
    private Button stage1, stage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        stage1 = findViewById(R.id.stage1);
        stage2 = findViewById(R.id.stage2);

        stage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "더이상 갈 필요가 없어", Toast.LENGTH_SHORT).show(); //stage1 클릭시 이미 클리어한 스테이지임을 표시
            }
        });

        stage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main2_2.this, st2_StartAndEnding_HowToPlay.class); //stage2로 화면이동
                startActivity(intent);
            }
        });
    }
}