package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st5_Background_6 extends AppCompatActivity {
    private Button st5_btn_updesk, st5_btn_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_background6);


        st5_btn_updesk = findViewById(R.id.st5_btn_updesk);
        st5_btn_updesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st5_Background_6.this, st5_Background_5.class); //Background5 화면으로 인테트
                startActivity(intent);
            }
        });

        st5_btn_box = findViewById(R.id.st5_btn_box);
        st5_btn_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "이 상자에는 아무것도 없는 것 같다..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}