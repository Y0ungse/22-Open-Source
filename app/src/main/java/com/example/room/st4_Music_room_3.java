package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class st4_Music_room_3 extends AppCompatActivity {
    private Button quiz_3, quiz_4, escape, quiz4_hint;
    private Button st4_btn_left;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_music_room3);

        quiz_3 = findViewById(R.id.st4_blackboard);
        quiz_4 = findViewById(R.id.st4_quiz4);

        // quiz3_whiteboard1 로 화면이동
        quiz_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(st4_Music_room_3.this, st4_quiz3_whiteboard1.class);
                startActivity(intent);
            }
        });

        st4_btn_left = findViewById(R.id.st4_btn_moving);
        st4_btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st4_Music_room_3.this, st4_Music_room_2.class);
                startActivity(intent);
                finish();
            }
        });

        // music room3로 화면이동
        quiz_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_3.this, st4_quiz4.class);
                startActivity(intent);
            }
        });

        // st4_unlock_final(최종 미술실 탈출씬)으로 화면이동
        escape = findViewById(R.id.st4_escape);
        escape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_3.this, st4_unlock_final.class);
                startActivity(intent);
            }
        });

        //
        quiz4_hint = findViewById(R.id.st4_hint4);
        quiz4_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "쪽지를 주웠다",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st4_Music_room_3.this, st4_quiz4_hint.class);
                startActivity(intent);
            }
        });
    }
}