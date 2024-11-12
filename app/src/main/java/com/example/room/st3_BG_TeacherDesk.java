package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st3_BG_TeacherDesk extends AppCompatActivity {

    // 해당 액티비티에서 사용할 버튼을 선언해놓는다.
    private Button btn_backHome;
    private Button btn_toTeacherHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_activity_teacherdesk); // 해당 이름의 xml과 동기화 시킨다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 버튼을 xml에 존재하는 버튼들과 링크시켜놓는다.
        btn_backHome = findViewById(R.id.st3_btn_teacherDeskToCenter);
        btn_toTeacherHint = findViewById(R.id.st3_btn_hint_teacherHint);

        btn_backHome.setOnClickListener(new View.OnClickListener() { // user가 돌아가는 버튼을 누른다면,
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_BG_TeacherDesk.this, st3_MainActivity.class);
                // 만약 돌아가는 버튼을 누른다면, 해당 액티비티에 오기 전 액티비티를 intent에 선언해놓는다.
                startActivity(intent);
                finish();
            }
        });

        btn_toTeacherHint.setOnClickListener(new View.OnClickListener() { // user이 단서로 가는 버튼을 누른다면,
            @Override
            public void onClick(View view) {
                if(st3_TryNumber.st3_ht3_try == 0) { // 만약 단서 버튼을 누르는 시도가 0이라면,
                    st3_TryNumber.st3_ht3_try++; // 시도를 1 추가해주고 (이미 봤다는 뜻)
                    Toast.makeText(getApplicationContext(), "쪽지 시험 종이 아이템을 획득하셨습니다.", Toast.LENGTH_LONG).show();
                    // 일회성 토스트 메시지를 출력한다.
                }
                Intent intent = new Intent(st3_BG_TeacherDesk.this, st3_Hint3_Teacher.class);
                startActivity(intent);
                // 토스트 메시지를 다 보고나서 더 구체적인 액티비티로 움직이도록 intent를 통해서 실행한다.
                finish();
                // finish를 통해서 액티비티를 종료시킨다.
            }
        });
    }
}
