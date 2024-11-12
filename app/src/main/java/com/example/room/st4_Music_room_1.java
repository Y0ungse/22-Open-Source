package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Scanner;

public class st4_Music_room_1 extends AppCompatActivity {
    private Button st4_piano, st4_right, st4_blackboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_music_room1);
        st4_gv.st4_is = getResources().openRawResource(R.raw.st4_gv1);
        st4_gv.st4_sc = new Scanner(st4_gv.st4_is, "UTF-8");
        st4_gv.st4_tv = findViewById(R.id.st4_text_gv1);
        st4_gv.st4_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st4_gv.st4_sc.hasNextLine()) {
                    String storyLine = st4_gv.st4_sc.nextLine();
                    st4_gv.st4_tv.setText(storyLine);
                }
                else
                    st4_gv.st4_tv.setVisibility(View.GONE);
            }
        });

        st4_piano = findViewById(R.id.st4_piano);
        st4_piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_1.this, st4_Music_piano.class);
                startActivity(intent);
            }
        });
        st4_right = findViewById(R.id.st4_right);
        st4_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_1.this, st4_Music_room_2.class);
                startActivity(intent);
            }
        });
        st4_blackboard = findViewById(R.id.st4_blackboard);
        st4_blackboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_Music_room_1.this, st4_Music_room_3.class);
                startActivity(intent);
            }
        });
    }
}