package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class st5_quiz_3 extends AppCompatActivity {
    private Button st5_btn_item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_quiz3);

        st5_btn_item2 = findViewById(R.id.st5_btn_item2);
        st5_btn_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_quiz_3.this, st5_Background_4.class); //Background54화면으로 인텐트
                startActivity(intent);
            }
        });
    }
}