package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class st2_hint1 extends AppCompatActivity {

    private Button st2_btn_click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_hint1);

        st2_btn_click = findViewById(R.id.st2_btn_click);
        st2_btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_hint1.this, st2_MainActivity.class);
                startActivity(intent); //액티비티 이동
                finish();
            }
        });


    }

}
