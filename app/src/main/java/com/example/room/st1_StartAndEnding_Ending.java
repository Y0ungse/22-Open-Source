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

public class st1_StartAndEnding_Ending extends AppCompatActivity {
    TextView tvv;
    private Button btn_st1_end;
    MediaPlayer st1_ending_media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_exit_layout);

        ///상단바 제거///
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// SharedPreference ///
        StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
        StageDB.editor = StageDB.sp.edit();


        st1_ending_media = MediaPlayer.create(st1_StartAndEnding_Ending.this, R.raw.st1_ending_song);
        st1_ending_media.start();

        /// st1 엔딩 스토리 읽기///
        st1_gv.st1_is = getResources().openRawResource(R.raw.st1_ending);
        st1_gv.st1_sc = new Scanner(st1_gv.st1_is, "MS949");
        st1_gv.st1_tv = (TextView) findViewById(R.id.st1_txt_ending);
        st1_gv.st1_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st1_gv.st1_sc.hasNextLine()) {
                    String storyLine = st1_gv.st1_sc.nextLine();
                    st1_gv.st1_tv.setText(storyLine);
                }
                else
                    st1_gv.st1_tv.setVisibility(View.GONE);
            }
        });


        /// st1 나가기 버튼 ///
        btn_st1_end = findViewById(R.id.st1_btn_end);
        btn_st1_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StageDB.editor.putString("stage1_clear", "clear");
                StageDB.editor.apply();

                // 정지버튼
                st1_ending_media.stop();
                // 초기화
                st1_ending_media.reset();

                Intent intent = new Intent(st1_StartAndEnding_Ending.this, main2_2.class);
                startActivity(intent);
            }
        });
    }

    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}