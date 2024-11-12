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


public class st2_StartAndEnding_Ending extends AppCompatActivity {
    MediaPlayer st2_mediaPlayer;
    Button st2_btn_finish;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_exit_layout);

        StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
        StageDB.editor = StageDB.sp.edit();

        st2_mediaPlayer = MediaPlayer.create(st2_StartAndEnding_Ending.this, R.raw.st2_exitsong);
        st2_mediaPlayer.start();

            st2_gv.is = getResources().openRawResource(R.raw.st2_exit);
            st2_gv.sc = new Scanner(st2_gv.is, "UTF-8");
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(st2_gv.sc.hasNextLine()) {
                        String storyLine = st2_gv.sc.nextLine();
                        st2_gv.tv.setText(storyLine);
                    }
                    else
                        st2_gv.tv.setVisibility(View.GONE);
                }
            });

        st2_btn_finish = (Button)findViewById(R.id.st2_btn_finish);
        st2_btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StageDB.editor.putString("stage2_clear", "clear");
                StageDB.editor.apply();

                // 정지버튼
                st2_mediaPlayer.stop();
                // 초기화
                st2_mediaPlayer.reset();
                Intent intent = new Intent(st2_StartAndEnding_Ending.this, main2_3.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if(st2_mediaPlayer != null) {
            st2_mediaPlayer.release();
            st2_mediaPlayer = null;
        }
    }

}
