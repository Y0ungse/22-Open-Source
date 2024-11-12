package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alexzaitsev.meternumberpicker.MeterView;

public class st4_quiz2 extends AppCompatActivity {
    MeterView st4_meterView;
    private Button st4_input ,st4_btn_hint2;
    private TextView st4_text_hint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz2);

        st4_text_hint2 = findViewById(R.id.st4_text_hint);
        st4_btn_hint2 = findViewById(R.id.st4_btn_hint);
        st4_btn_hint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_quiz2.this, st4_popup_quizhint.class);
                intent.putExtra("data", "민정이의 악기상자\n\n\"근처에 떨어진 쪽지를 찾아보자\"\n\n영단어를 다시 한 번 생각해보자 \n\n\nA는 숫자 몇과 대응할까?\n ");
                startActivity(intent);
            }
        });

        st4_meterView = findViewById(R.id.st4_meterView);
        st4_input = findViewById(R.id.st4_input);
        st4_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = st4_meterView.getValue();

                if(number == 3212) {
                    Toast.makeText(getApplicationContext(), "민정이의 악기 상자가 열렸습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(st4_quiz2.this, st4_quiz2_trumpet.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "땡", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}