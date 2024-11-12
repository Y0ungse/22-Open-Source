package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_lectureDeskPw extends AppCompatActivity {
    private EditText st1_ld_pw_input;           /// 암호값 받는 editText ///
    private Button st1_ld_pw_open;              ///  (암호값 이후 누르는) 확인 버튼 ///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_lecture_desk_pw);

        /// 상단바 제거 ///
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// 교탁 자물쇠 ///
        st1_ld_pw_input = (EditText) findViewById(R.id.st1_ld_pw_input);

        st1_ld_pw_open = (Button) findViewById(R.id.st1_ld_pw_open);
        st1_ld_pw_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// 암호 ///
                String pw = st1_ld_pw_input.getText().toString();      ///암호 받기///

                /// 암호 맞는지 check ///
                if (pw.equals("Victim") || pw.equals("victim") || pw.equals("VICTIM")) {                                /// 맞는지 check
                    Toast.makeText(st1_lectureDeskPw.this, "서랍을 열었다.", Toast.LENGTH_SHORT).show();       /// toast message
                    Intent intent = new Intent(st1_lectureDeskPw.this, st1_lectureDeskOpen.class);         /// 열린 교탁으로 이동
                    startActivity(intent);                                                                             /// 열린 교탁으로 이동
                }

                else {                      ///틀리면 activity 종료   -> 다시 교탁 서랍으로 이동 ///
                    Toast.makeText(st1_lectureDeskPw.this, "열리지 않는다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}