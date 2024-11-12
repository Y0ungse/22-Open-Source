package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class st4_quiz3_whiteboard2 extends AppCompatActivity {
    private Button st4_get_E;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz3_whiteboard2);

        //st4_unlock3(3번째글자)로 화면이동
        st4_get_E = findViewById(R.id.st4_quiz3_unlock);
        st4_get_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "세번째 숫자를 획득하였습니다", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(st4_quiz3_whiteboard2.this, st4_unlock3.class);
                startActivity(intent);
            }
        });
    }
}