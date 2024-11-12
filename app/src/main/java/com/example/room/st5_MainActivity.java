package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st5_MainActivity extends AppCompatActivity {
    private Button st5_btn_downstair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.st5_activity_main);

        st5_gv.st5_is = getResources().openRawResource(R.raw.st5_first);
        st5_gv.st5_sc = new Scanner(st5_gv.st5_is, "UTF-8");
        st5_gv.st5_tv = findViewById(R.id.st5_text_1);
        st5_gv.st5_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st5_gv.st5_sc.hasNextLine()) {
                    String storyLine = st5_gv.st5_sc.nextLine();
                    st5_gv.st5_tv.setText(storyLine);
                }
                else
                    st5_gv.st5_tv.setVisibility(View.GONE);
            }
        });


        st5_btn_downstair = findViewById(R.id.st5_btn_downstair); //Background_2 화면으로 인텐트
        st5_btn_downstair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_MainActivity.this, st5_Background_2.class);
                startActivity(intent);
            }
        });
        startService(new Intent(getApplicationContext(), st5_MusicService.class)); //앱 실행시 MusicService 실행
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(getApplicationContext(), st5_MusicService.class)); //앱 종료시
        super.onDestroy(); //MusicService 종료
    }
}