package com.example.room;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st1_StartAndEnding_Story extends AppCompatActivity {

    MediaPlayer st1_opening_media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_start_story);

        ///상단바 제거///
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        /// st1 오프닝///
        st1_gv.st1_is = getResources().openRawResource(R.raw.st1_opening);
        st1_gv.st1_sc = new Scanner(st1_gv.st1_is, "MS949");
        st1_gv.st1_tv = (TextView) findViewById(R.id.st1_txt_opening);
        st1_gv.st1_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st1_gv.st1_sc.hasNextLine()) {
                    String storyLine = st1_gv.st1_sc.nextLine();
                    st1_gv.st1_tv.setText(storyLine);
                }
                else {
                    st1_gv.st1_tv.setVisibility(View.GONE);

                    /// (opening에서 마지막) 풀썩 효과음
                    st1_opening_media = MediaPlayer.create(st1_StartAndEnding_Story.this, R.raw.st1_bodydrop);
                    st1_opening_media.start();


                    /// 교실 MainStage로 이동 ///
                    Intent intent = new Intent(st1_StartAndEnding_Story.this, st1_MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}