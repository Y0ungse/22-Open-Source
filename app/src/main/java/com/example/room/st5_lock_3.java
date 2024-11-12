package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

public class st5_lock_3 extends AppCompatActivity {
    PatternLockView st5_patternLockView;
    private Button st5_btn_hint3;
    private TextView st5_text_hint3;
    int currentStage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_lock3);

        st5_text_hint3 = findViewById(R.id.st5_text_hint);
        st5_btn_hint3 = findViewById(R.id.st5_btn_hint);
        st5_btn_hint3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_lock_3.this, st5_PopUp_QuizHint.class); //퀴즈3 힌트 다이어로그로 인텐트
                intent.putExtra("data", "HINT FOR QUIZ3\n\n\"패턴으로 별을 그려야 한다\"\n\"패턴은 5 -> 1 -> 6 순으로 시작한다");
                startActivity(intent);


            }
        });


        st5_patternLockView = findViewById(R.id.st5_pattern_lock_view); //patterlockview 참조
        st5_patternLockView.addPatternLockListener(new PatternLockViewListener() { //patterlocklistner 생성
            @Override
            public void onStarted() {
                Log.d(getClass().getName(), "Pattern drawing started");
            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {
                Log.d(getClass().getName(), "Pattern progress: " +
                        PatternLockUtils.patternToString(st5_patternLockView, progressPattern)); //patterlockview에 입력된 값을 String형으로 변환
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                Log.d(getClass().getName(), "Pattern complete: " +
                        PatternLockUtils.patternToString(st5_patternLockView, pattern));
                if (PatternLockUtils.patternToString(st5_patternLockView, pattern).equalsIgnoreCase("405618327")) { //String이 405618327 이라면
                    Toast.makeText(getApplicationContext(), "탈출문이 열렸습니다.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(st5_lock_3.this, st5_escape.class);
                    startActivity(intent);
                }

                else { //String이 405618327이 아니라면
                    Toast.makeText(getApplicationContext(), "패턴이 틀렸습니다", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCleared() {
                Log.d(getClass().getName(), "Pattern has been cleared");
            }
        });
    }
}