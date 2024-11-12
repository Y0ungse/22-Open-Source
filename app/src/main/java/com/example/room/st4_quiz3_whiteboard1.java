package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class st4_quiz3_whiteboard1 extends AppCompatActivity {
    private Button st4_move_board_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz3_whiteboard);

        // quiz3_whiteboard2 로 화면이동
        st4_move_board_2 = findViewById(R.id.st4_move_quiz3_whiteboard2);
        st4_move_board_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "칠판이 지워진다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st4_quiz3_whiteboard1.this, st4_quiz3_whiteboard2.class);
                startActivity(intent);
            }
        });
    }
}