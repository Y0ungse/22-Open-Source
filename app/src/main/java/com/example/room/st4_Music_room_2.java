package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class st4_Music_room_2 extends AppCompatActivity {
    private Button st4_left, st4_behind, st4_paper, st4_trumpet_case;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_music_room2);

        // music room1로 화면이동
        st4_left = findViewById(R.id.st4_left);
        st4_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_2.this, st4_Music_room_1.class);
                startActivity(intent);
            }
        });
        // music room3로 화면이동
        st4_behind = findViewById(R.id.st4_behind);
        st4_behind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_2.this, st4_Music_room_3.class);
                startActivity(intent);
            }
        });
        // trumpet case로 화면이동
        st4_trumpet_case = findViewById(R.id.st4_trumpet_case);
        st4_trumpet_case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_2.this, st4_quiz2_trumpet_case.class);
                startActivity(intent);
            }
        });
        // st4_quiz2_hint로 화면이동
        st4_paper = findViewById(R.id.st4_paper);
        st4_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "누군가의 고민이 담긴 쪽지를 발견했습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st4_Music_room_2.this, st4_quiz2_hint.class);
                startActivity(intent);
            }
        });
    }
}