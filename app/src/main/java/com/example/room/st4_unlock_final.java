package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st4_unlock_final extends AppCompatActivity {

    EditText st4_text_answer;
    private Button st4_btn_quiz_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st4_unlock_final);

        st4_text_answer = findViewById(R.id.st4_text_answer);
        st4_btn_quiz_input = findViewById(R.id.st4_btn_final_input);


        st4_btn_quiz_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                str = st4_text_answer.getText().toString();


                if(str.length() == 4) {
                    if(str.equals("PREY")) {
                        Toast.makeText(getApplicationContext(), "음악실 탈출 성공", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(st4_unlock_final.this, st4_StartAndEnding_Ending.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "틀렸습니다", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(), "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}