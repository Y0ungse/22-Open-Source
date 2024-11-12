package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class st3_StartAndEnding_HowToPlay extends AppCompatActivity {

    Button st3_btn_gotoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_start_howtoplay);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        st3_btn_gotoMain = findViewById(R.id.st3_btn_goToMain);
        st3_btn_gotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_StartAndEnding_HowToPlay.this, st3_MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
