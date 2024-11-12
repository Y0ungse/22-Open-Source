package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class st4_StartAndEnding_HowToPlay extends AppCompatActivity {

    Button st3_btn_gotoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st4_start_and_ending_how_to_play);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        st3_btn_gotoMain = findViewById(R.id.st4_btn_goToMain);
        st3_btn_gotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st4_StartAndEnding_HowToPlay.this, st4_Music_room_1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}