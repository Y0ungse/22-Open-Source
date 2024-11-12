package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st2_exitCode extends AppCompatActivity {
    private Button st2_btn_input, st2_btn_hint, st2_btn_back;
    EditText st2_exit_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_exit_code);

        st2_btn_hint = (Button)findViewById(R.id.st2_btn_hint);
        st2_btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st2_exitCode.this, st2_hint3.class);
                startActivity(intent);
                finish();
            }
        });

        st2_btn_back = (Button)findViewById(R.id.st2_btn_back);
        st2_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st2_exitCode.this, st2_MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        st2_btn_input = (Button)findViewById(R.id.st2_btn_input);
        st2_exit_txt = (EditText)findViewById(R.id.st2_exit_txt);

        st2_btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st2_str="";
                st2_str = st2_exit_txt.getText().toString();

                if(st2_str.equals("Gold") || st2_str.equals("gold") || st2_str.equals("GOLD")){
                    Toast.makeText(st2_exitCode.this, "정답입니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(st2_exitCode.this, st2_StartAndEnding_Ending.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(st2_exitCode.this, "오답입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}