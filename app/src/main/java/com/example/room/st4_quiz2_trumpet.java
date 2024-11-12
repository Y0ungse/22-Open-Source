package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class st4_quiz2_trumpet extends AppCompatActivity {
    private Button st4_movefront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz2_trumpet);

        // st4_quiz2_trumpet - > st_quiz2_trumpet_front로 화면이동
        st4_movefront = findViewById(R.id.st4_movefront);
        st4_movefront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_quiz2_trumpet.this, st4_quiz2_trumpet_front.class);
                startActivity(intent);
            }
        });
    }
}