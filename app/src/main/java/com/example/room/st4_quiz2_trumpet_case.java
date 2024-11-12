package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class st4_quiz2_trumpet_case extends AppCompatActivity {
    private Button st4_quiz_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz2_trumpet_case);

        // st4_quiz2_trumpet_case -> st4_quiz2로 화면이동
        st4_quiz_2 = findViewById(R.id.st4_Quiz_2);
        st4_quiz_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_quiz2_trumpet_case.this, st4_quiz2.class);
                Toast.makeText(getApplicationContext(), "민정이의 악기 상자를 발견했다! 자물쇠는 어떻게 열지?", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}