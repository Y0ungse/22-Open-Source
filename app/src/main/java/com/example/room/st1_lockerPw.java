package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_lockerPw extends AppCompatActivity {
    private EditText st1_lo_pw_input;
    private Button st1_lo_pw_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_locker_pw);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// 사물함 자물쇠 ///
        st1_lo_pw_input = (EditText) findViewById(R.id.st1_lo_pw_input);    /// 입력 ///

        st1_lo_pw_open = (Button) findViewById(R.id.st1_lo_pw_open);        ///열기 버튼 ///
        st1_lo_pw_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// 암호 ///
                String pw = st1_lo_pw_input.getText().toString();

                /// 맞는지 check ///
                if (pw.equals("8146")) {                       ///암호 맞는지 check
                    Toast.makeText(st1_lockerPw.this, "사물함이 열렸다.", Toast.LENGTH_SHORT).show();      ///toast messgae
                    Intent intent = new Intent(st1_lockerPw.this, st1_lockerOpen.class);               /// 열린 사물함 Activity로 이동
                    startActivity(intent);
                }

                else {
                    Toast.makeText(st1_lockerPw.this, "비밀번호가 틀린 듯 하다.", Toast.LENGTH_SHORT).show();     ///toast message
                    finish();                                                                                            /// activity 종료
                }
            }
        });
    }
}