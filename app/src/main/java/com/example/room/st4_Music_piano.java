package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class st4_Music_piano extends AppCompatActivity {
    private Button st4_right, st4_movePiano, st4_quiz1; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_music_piano);

        st4_right = findViewById(R.id.st4_right);
        st4_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_piano.this, st4_Music_room_2.class);
                startActivity(intent);
            }
        });

        st4_movePiano = findViewById(R.id.st4_movepiano);
        st4_movePiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_piano.this, st4_piano.class);
                startActivity(intent);
            }
        });

        st4_quiz1 = findViewById(R.id.st4_Quiz_1);
        st4_quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "악보 속 지워진 음 3개를 맞춰보자! 피아노건반이 도움이 될지도 몰라", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st4_Music_piano.this, st4_quiz1.class);
                startActivity(intent);
            }
        });
    }
}