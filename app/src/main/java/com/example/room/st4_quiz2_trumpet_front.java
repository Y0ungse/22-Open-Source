package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class st4_quiz2_trumpet_front extends AppCompatActivity {
    private Button st4_get_R;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz2_trumpet_answer);

        // st4_unlock2(2번째글자)로 화면이동
        st4_get_R = findViewById(R.id.st4_get_R);
        st4_get_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"두번째 글자를 획득하였습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st4_quiz2_trumpet_front.this, st4_unlock2.class);
                startActivity(intent);
            }
        });
    }
}