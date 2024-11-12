package com.example.room;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class exit_secte extends AppCompatActivity {

    MediaPlayer exit_mediaPlayer;
    private Button exit_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_secte);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        exit_mediaPlayer = MediaPlayer.create(exit_secte.this, R.raw.exit_sectemusic);
        exit_mediaPlayer.start();

        exit_gv.exit_is = getResources().openRawResource(R.raw.exit_secte);
        exit_gv.exit_sc = new Scanner(exit_gv.exit_is, "UTF-8");
        exit_gv.exit_tv = (TextView) findViewById(R.id.exit_txt);
        exit_gv.exit_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(exit_gv.exit_sc.hasNextLine()) {
                    String storyLine = exit_gv.exit_sc.nextLine();
                    exit_gv.exit_tv.setText(storyLine);
                }
                else
                    exit_gv.exit_tv.setVisibility(View.GONE);
            }
        });

        exit_back = findViewById(R.id.exit_back);
        exit_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit_mediaPlayer.stop();
                exit_mediaPlayer.reset();

                Intent intent = new Intent(exit_secte.this, exit_stairs.class);
                startActivity(intent); //액티비티 이동
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if(exit_mediaPlayer != null) {
            exit_mediaPlayer.release();
            exit_mediaPlayer = null;
        }
    }

}
