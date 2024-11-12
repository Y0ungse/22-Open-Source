package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st2_MainActivity extends AppCompatActivity {

    private Button st2_btn_zoomIn, st2_btn_paper, st2_btn_exit;

    HorizontalScrollView st2_horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_main);
        st2_horizontalScrollView = findViewById(R.id.st2_horizontalScrollView);
        st2_horizontalScrollView.setHorizontalScrollBarEnabled(true);


        if (st2_tryNumber.st2_main_try == 0) {

            st2_gv.is = getResources().openRawResource(R.raw.st2_story);
            st2_gv.sc = new Scanner(st2_gv.is, "UTF-8");
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (st2_gv.sc.hasNextLine()) {
                        String storyLine = st2_gv.sc.nextLine();
                        st2_gv.tv.setText(storyLine);
                    } else
                        st2_gv.tv.setVisibility(View.GONE);
                }
            });
            st2_tryNumber.st2_main_try++;
        }
        else if(st2_tryNumber.st2_main_try == 1) {

            st2_gv.tv.setVisibility(View.VISIBLE);
            st2_gv.is = getResources().openRawResource(R.raw.st2_paper);
            st2_gv.sc = new Scanner(st2_gv.is, "UTF-8");
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (st2_gv.sc.hasNextLine()) {
                        String storyLine = st2_gv.sc.nextLine();
                        st2_gv.tv.setText(storyLine);
                    } else
                        st2_gv.tv.setVisibility(View.GONE);
                }
            });
            st2_tryNumber.st2_main_try++;

        } else if(st2_tryNumber.st2_main_try == 2) {

            st2_gv.tv.setVisibility(View.VISIBLE);
            st2_gv.is = getResources().openRawResource(R.raw.st2_door_no);
            st2_gv.sc = new Scanner(st2_gv.is, "UTF-8");
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (st2_gv.sc.hasNextLine()) {
                        String storyLine = st2_gv.sc.nextLine();
                        st2_gv.tv.setText(storyLine);
                    } else
                        st2_gv.tv.setVisibility(View.GONE);
                }

            });
            st2_tryNumber.st2_main_try++;

        } else {
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setVisibility(View.GONE);
        }

        st2_btn_zoomIn = findViewById(R.id.st2_btn_zoomIn);
        st2_btn_zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_MainActivity.this, st2_Sub1Activity.class);
                startActivity(intent); //액티비티 이동
                finish();

            }
        });

        st2_btn_exit = findViewById(R.id.st2_btn_exit);
        st2_btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_MainActivity.this, st2_exitCode.class);
                startActivity(intent); //액티비티 이동
                finish();
            }
        });

        st2_btn_paper = findViewById(R.id.st2_btn_paper);
        st2_btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_MainActivity.this, st2_paper.class);
                startActivity(intent); //액티비티 이동
                finish();

            }
        });
    }
}