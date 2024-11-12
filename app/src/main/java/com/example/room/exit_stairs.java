package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class exit_stairs extends AppCompatActivity {

    private Button exit_outside, exit_secte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_stairs);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(exit_tryNumber.exit_try == 0) {
            exit_gv.exit_is = getResources().openRawResource(R.raw.exit_stairs1);
            exit_gv.exit_sc = new Scanner(exit_gv.exit_is, "UTF-8");
            exit_gv.exit_tv = (TextView) findViewById(R.id.exit_txt);
            exit_gv.exit_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(exit_gv.exit_sc.hasNextLine()) {
                        String storyLine = exit_gv.exit_sc.nextLine();
                        exit_gv.exit_tv.setText(storyLine);
                    } else {
                        exit_gv.exit_tv.setVisibility(View.GONE);
                    }
                }
            });
            exit_tryNumber.exit_try++;
        }
        else {
            exit_gv.exit_is = getResources().openRawResource(R.raw.exit_stairs2);
            exit_gv.exit_sc = new Scanner(exit_gv.exit_is, "UTF-8");
            exit_gv.exit_tv = (TextView) findViewById(R.id.exit_txt);
            exit_gv.exit_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(exit_gv.exit_sc.hasNextLine()) {
                        String storyLine = exit_gv.exit_sc.nextLine();
                        exit_gv.exit_tv.setText(storyLine);
                    } else {
                        exit_gv.exit_tv.setVisibility(View.GONE);
                    }
                }
            });
        }

        exit_outside = findViewById(R.id.exit_outside);
        exit_outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exit_stairs.this, exit_outside.class);
                startActivity(intent);
            }
        });

        exit_secte = findViewById(R.id.exit_secte);
        exit_secte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exit_stairs.this, exit_secte.class);
                startActivity(intent);
            }
        });
    }
}