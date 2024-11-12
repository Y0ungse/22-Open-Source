package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st2_Sub2Activity extends AppCompatActivity {

    private Button st2_btn_back2, st2_btn_pallet, st2_btn_acrylic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_sub2);

        if(st2_tryNumber.st2_Sub2_try == 0){
            st2_tryNumber.st2_Sub2_try++;

            st2_gv.is = getResources().openRawResource(R.raw.st2_art_tools);
            st2_gv.sc = new Scanner(st2_gv.is, "UTF-8");
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(st2_gv.sc.hasNextLine()) {
                        String storyLine = st2_gv.sc.nextLine();
                        st2_gv.tv.setText(storyLine);
                    }
                    else
                        st2_gv.tv.setVisibility(View.GONE);
                }
            });
        } else {
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setVisibility(View.GONE);
        }

        st2_btn_back2 = findViewById(R.id.st2_btn_back2);
        st2_btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_Sub2Activity.this, st2_Sub1Activity.class);
                startActivity(intent); //액티비티 이동
            }
        });

        st2_btn_pallet = findViewById(R.id.st2_btn_pallet);
        st2_btn_pallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(st2_tryNumber.st2_paint_item1_try == 0) {
                    Toast.makeText(st2_Sub2Activity.this, "파레트를 획득하였습니다.", Toast.LENGTH_SHORT).show();
                }

                st2_tryNumber.st2_paint_item1_try++;

            }
        });

        st2_btn_acrylic = findViewById(R.id.st2_btn_acrylic);
        st2_btn_acrylic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(st2_tryNumber.st2_paint_item2_try == 0) {
                    Toast.makeText(st2_Sub2Activity.this, "물감을 획득하였습니다.", Toast.LENGTH_SHORT).show();
                }
                st2_tryNumber.st2_paint_item2_try++;

            }
        });


    }
}