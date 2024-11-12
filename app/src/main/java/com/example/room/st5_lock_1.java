package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alexzaitsev.meternumberpicker.MeterView;

public class st5_lock_1 extends AppCompatActivity {
    MeterView meterView;
    private Button st5_btn_input, st5_btn_hint1;
    private TextView st5_text_hint1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_lock1);

        st5_text_hint1 = findViewById(R.id.st5_text_hint);
        st5_btn_hint1 = findViewById(R.id.st5_btn_hint1);
        st5_btn_hint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_lock_1.this, st5_PopUp_QuizHint.class); //퀴즈1 힌트 다이어로그로 인텐트
                intent.putExtra("data", "HINT FOR QUIZ1\n\n\"먼저 배수관에서 쪽지를 얻자\"\n\"쪽지에 적힌 2진수를 10진수로 바꾸자");
                startActivity(intent);
            }
        });

        meterView = findViewById(R.id.st5_meterView); //meterView 참조
        st5_btn_input = findViewById(R.id.st5_btn_input);
        st5_btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = meterView.getValue(); //meterView에 입력된 수를 int형으로 변환

                if (number == 2937) { //number가 2937이라면
                    Toast.makeText(getApplicationContext(), "문이 열렸습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(st5_lock_1.this, st5_Background_4.class); //Background4 화면으로 인텐트
                    startActivity(intent);
                }

                else { //number가 2937이 아니라면
                    Toast.makeText(getApplicationContext(), "비밀 번호가 틀렸습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}