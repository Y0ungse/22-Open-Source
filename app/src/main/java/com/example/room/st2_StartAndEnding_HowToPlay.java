package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class st2_StartAndEnding_HowToPlay extends AppCompatActivity {

    Button st2_btn_gotoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st2_start_howtoplay);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        st2_btn_gotoMain = findViewById(R.id.st2_btn_goToMain);
        st2_btn_gotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st2_StartAndEnding_HowToPlay.this, st2_MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
