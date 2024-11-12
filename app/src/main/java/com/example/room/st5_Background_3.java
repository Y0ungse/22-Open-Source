package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st5_Background_3 extends AppCompatActivity {
    private Button st5_btn_back, st5_btn_item1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_background3);

        st5_btn_back = findViewById(R.id.st5_btn_back); //Background2 화면으로 인텐트
        st5_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_Background_3.this, st5_Background_2.class);
                startActivity(intent);
            }
        });

        st5_btn_item1 = findViewById(R.id.st5_btn_item1); //item1 화면으로 인텐트
        st5_btn_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "아이템을 획득하였습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st5_Background_3.this, st5_quiz_1.class);
                startActivity(intent);

            }
        });
    }
}