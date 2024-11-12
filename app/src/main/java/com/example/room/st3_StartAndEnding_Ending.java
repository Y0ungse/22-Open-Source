package com.example.room;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st3_StartAndEnding_Ending extends AppCompatActivity {

    private Button btn_st3_end; // 엔딩 종료 버튼
    MediaPlayer st3_ending_media; // 엔딩 bgm

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_exit_layout); // xml과 동기화

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 해당 화면을 꽉 찬 화면으로 만들어 액션바와 상단바를 없앨 수 있다.

        StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
        // StageDB에 있는 SharedPreference를 선언.
        StageDB.editor = StageDB.sp.edit();
        // 수정할 수 있게 선언해준다.

        st3_ending_media = MediaPlayer.create(st3_StartAndEnding_Ending.this, R.raw.st3_bgm);
        // 엔딩화면에 도착하면 기본적으로 bgm이 깔린다.
        st3_ending_media.start();

        // 스토리 넘겨주기 (여러 번 설명했으므로 주석은 생략한다.)
        st3_gv.st3_is = getResources().openRawResource(R.raw.st3_ending_storyline);
        st3_gv.st3_sc = new Scanner(st3_gv.st3_is, "UTF-8");
        st3_gv.st3_tv = (TextView) findViewById(R.id.st3_txt_ending);
        st3_gv.st3_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st3_gv.st3_sc.hasNextLine()) {
                    String storyLine = st3_gv.st3_sc.nextLine();
                    st3_gv.st3_tv.setText(storyLine);
                }
                else
                    st3_gv.st3_tv.setVisibility(View.GONE);
            }
        });

        // 종료 버튼을 누르면
        btn_st3_end = findViewById(R.id.st3_btn_end);
        btn_st3_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StageDB.editor.putString("stage3_clear", "clear");
                // DB의 speditor가 stage3_clear의 변수에 clear이라는 값을 기입하게 만든다.
                StageDB.editor.apply();
                // 적용시킨다.
                // 따라서 스테이지3의 엔딩을 다 보고 종료 버튼을 누르면, SP에 해당 값이 기록되고,
                // 어플을 껐다가 켜도 Stage3은 해결이 됐다고 나온다.
                // 이것이 SharedPreferences를 사용하는 목적이다.

                st3_ending_media.stop(); // 동시에 bgm 종료 (다음 액티비티에 영향을 안 주기 위함)
                st3_ending_media.reset(); // 초기화

                Intent intent = new Intent(st3_StartAndEnding_Ending.this, main2_4.class);
                startActivity(intent); // 메인 화면으로 나가도록 하자.

            }
        });
    }
}
