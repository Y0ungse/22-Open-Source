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

public class exit_outside extends AppCompatActivity {

    private Button exit_finish;
    MediaPlayer exit_mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_outside);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
        StageDB.editor = StageDB.sp.edit();

        exit_mediaPlayer = MediaPlayer.create(exit_outside.this, R.raw.exit_outsidemusic);
        exit_mediaPlayer.start();

        exit_gv.exit_is = getResources().openRawResource(R.raw.exit_outside);
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

        exit_finish = findViewById(R.id.exit_finish);
        exit_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StageDB.editor.putString("stage1_clear","unclear");
                StageDB.editor.apply();
                StageDB.editor.putString("stage2_clear","unclear");
                StageDB.editor.apply();
                StageDB.editor.putString("stage3_clear","unclear");
                StageDB.editor.apply();
                StageDB.editor.putString("stage4_clear","unclear");
                StageDB.editor.apply();

                exit_mediaPlayer.stop();
                exit_mediaPlayer.reset();

                Intent intent = new Intent(exit_outside.this, MainActivity.class);
                startActivity(intent);
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
