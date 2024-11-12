package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class st4_quiz1 extends AppCompatActivity {
    private Button st4_input_1, st4_input_2, st4_input_3, st4_input_4;
    SoundPool pool;
    int st4_music_1, st4_music_2, st4_music_3, st4_music_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //상단바 삭제
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz1);


        pool = new SoundPool(4, AudioManager.STREAM_MUSIC,0);
        st4_music_1 = pool.load(this,R.raw.st4_music_1,1);
        st4_music_2 = pool.load(this,R.raw.st4_music_2,1);
        st4_music_3 = pool.load(this,R.raw.st4_music_3,1);
        st4_music_4 = pool.load(this,R.raw.st4_music_4,1);

        st4_input_1 = findViewById(R.id.st4_input_1);
        st4_input_2 = findViewById(R.id.st4_input_2);
        st4_input_3 = findViewById(R.id.st4_input_3);
        st4_input_4 = findViewById(R.id.st4_input_4);

        st4_input_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "땡", Toast.LENGTH_SHORT).show();
            }
        });

        st4_input_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "땡", Toast.LENGTH_SHORT).show();
            }
        });

        st4_input_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "첫번째 글자를 획득하였습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st4_quiz1.this, st4_unlock1.class);
                startActivity(intent);
            }
        });

        st4_input_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "땡", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void mOnClick(View v){

        switch(v.getId())
        {
            case R.id.st4_music1:
                pool.play(st4_music_1,1,1,0,0,1);
                break;
            case R.id.st4_music2:
                pool.play(st4_music_2,1,1,0,0,1);
                break;
            case R.id.st4_music3:
                pool.play(st4_music_3,1,1,0,0,1);
                break;
            case R.id.st4_music4:
                pool.play(st4_music_4,1,1,0,0,1);
                break;

        }
    }
}