package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Scanner;

public class st4_StartAndEnding_Ending extends AppCompatActivity {
    private Button loby;
    MediaPlayer st4_ending_media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st4_final_escape);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
        StageDB.editor = StageDB.sp.edit();

        st4_ending_media = MediaPlayer.create(st4_StartAndEnding_Ending.this, R.raw.st4_ending_media);
        st4_ending_media.start();

        st4_gv.st4_is = getResources().openRawResource(R.raw.st4_end);
        st4_gv.st4_sc = new Scanner(st4_gv.st4_is, "UTF-8");
        st4_gv.st4_tv = findViewById(R.id.st4_text_gv2);
        st4_gv.st4_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (st4_gv.st4_sc.hasNextLine()) {
                    String storyLine = st4_gv.st4_sc.nextLine();
                    st4_gv.st4_tv.setText(storyLine);
                } else
                    st4_gv.st4_tv.setVisibility(View.GONE);
            }
        });

        loby = findViewById(R.id.loby);
        loby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StageDB.editor.putString("stage4_clear", "clear");
                StageDB.editor.apply();

                st4_ending_media.stop();
                st4_ending_media.reset();

                Intent intent = new Intent(st4_StartAndEnding_Ending.this, main2_5.class);
                startActivity(intent);
            }
        });
    }
}
