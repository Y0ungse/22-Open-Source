package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class st4_unlock4 extends AppCompatActivity {
    private Button st4_paper_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_quiz4_unlock);

        st4_paper_4 = findViewById(R.id.st4_unlock4);
        st4_paper_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st4_unlock4.this, st4_Music_room_3.class);
                startActivity(intent);
            }
        });
    }
}