package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class st1_StartAndEnding_HowToPlay extends AppCompatActivity {
    Button st1_btn_gotoMain;                /// opening으로 가는 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_start_howtoplay);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        st1_btn_gotoMain = findViewById(R.id.st1_btn_goToMain);
        st1_btn_gotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_StartAndEnding_HowToPlay.this, st1_StartAndEnding_Story.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}
