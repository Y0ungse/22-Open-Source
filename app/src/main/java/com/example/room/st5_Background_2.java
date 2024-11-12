package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st5_Background_2 extends AppCompatActivity {
    private Button st5_btn_upstair, st5_btn_hidden, st5_btn_quiz1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_background2);

        st5_gv.st5_is = getResources().openRawResource(R.raw.st5_second);
        st5_gv.st5_sc = new Scanner(st5_gv.st5_is, "UTF-8");
        st5_gv.st5_tv = findViewById(R.id.st5_text_2);
        st5_gv.st5_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st5_gv.st5_sc.hasNextLine()) {
                    String storyLine = st5_gv.st5_sc.nextLine();
                    st5_gv.st5_tv.setText(storyLine);
                }
                else
                    st5_gv.st5_tv.setVisibility(View.GONE);
            }
        });


        st5_btn_upstair = findViewById(R.id.st5_btn_upstair); //1번째 화면으로 인텐트
        st5_btn_upstair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_Background_2.this, st5_MainActivity.class);
                startActivity(intent);
            }
        });

        st5_btn_hidden = findViewById(R.id.st5_btn_hidden); //3번째 화면으로 인텐트
        st5_btn_hidden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_Background_2.this, st5_Background_3.class);
                startActivity(intent);
            }
        });

        st5_btn_quiz1 = findViewById(R.id.st5_btn_door); //1번째 퀴즈 화면으로 인텐트
        st5_btn_quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "배수관을 살펴 보자", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(st5_Background_2.this, st5_lock_1.class);
                startActivity(intent);
            }
        });
    }
}