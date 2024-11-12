package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class st5_quiz_1 extends AppCompatActivity {
    private Button st5_btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_quiz1);

        st5_btn_back = findViewById(R.id.st5_btn_back);
        st5_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_quiz_1.this, st5_Background_2.class); //Background2 화면으로 인텐트
                startActivity(intent);
            }
        });
    }
}