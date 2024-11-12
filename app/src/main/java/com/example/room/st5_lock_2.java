package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alexzaitsev.meternumberpicker.MeterView;

public class st5_lock_2 extends AppCompatActivity {
    MeterView st5_meterView;
    private Button st5_btn_input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_lock2);


        st5_meterView = findViewById(R.id.st5_meterView); //meterView 참조
        st5_btn_input2 = findViewById(R.id.st5_btn_input2);
        st5_btn_input2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = st5_meterView.getValue(); //meterView에 입력된 수를 int형으로 변환

                if (number == 1537) { //number가 1537 이라면
                    Toast.makeText(getApplicationContext(), "캐비넷이 열렸습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(st5_lock_2.this, st5_quiz_3.class); //quiz3화면으로 인텐트
                    startActivity(intent);
                }

                else { //number가 1537이 아니라면
                    Toast.makeText(getApplicationContext(), "비밀 번호가 틀렸습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}