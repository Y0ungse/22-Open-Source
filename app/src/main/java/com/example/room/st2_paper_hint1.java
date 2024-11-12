package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st2_paper_hint1 extends AppCompatActivity {

    private Button st2_btn_hint, st2_btn_submit, st2_btn_back;
    EditText st2_exit_txt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_paper_hint1);

        st2_btn_hint = findViewById(R.id.st2_btn_hint);
        st2_btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_paper_hint1.this, st2_paper_hint2.class);
                startActivity(intent); //액티비티 이동
            }
        });

        st2_btn_back = findViewById(R.id.st2_btn_back);
        st2_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_paper_hint1.this, st2_MainActivity.class);
                startActivity(intent); //액티비티 이동
            }
        });

        st2_btn_submit = findViewById(R.id.st2_btn_input);
        st2_exit_txt = (EditText)findViewById(R.id.st2_exit_txt);
        st2_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st2_str = "";
                st2_str = st2_exit_txt.getText().toString();

                if (st2_str.equals("4723") || st2_str.equals("4723 ") || st2_str.equals(" 4723") || st2_str.equals("4 7 2 3")) {
                    Toast.makeText(st2_paper_hint1.this, "정답입니다.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(st2_paper_hint1.this, "특수종이를 획득하였습니다.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(st2_paper_hint1.this, "힌트 버튼을 눌러 확인하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(st2_paper_hint1.this, "오답입니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
