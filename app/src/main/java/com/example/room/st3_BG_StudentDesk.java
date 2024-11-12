package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st3_BG_StudentDesk extends AppCompatActivity {

    // 해당 java에서 쓸 변수들 선언
    private Button btn_backHome;
    private Button btn_hint_studentHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_activity_studentdesk);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 쓸 버튼을 미리 xml과 링크해준다. findViewById를 통해서
        btn_backHome = findViewById(R.id.st3_btn_studentDeskToRoot); // 단서를 얻는 화면에서 원래 화면으로 돌아가는 버튼.
        btn_hint_studentHint = findViewById(R.id.st3_btn_hint_studentHint); // 단서 버튼


        btn_backHome.setOnClickListener(new View.OnClickListener() { // 만약 되돌아가는 키를 누른다면,
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_BG_StudentDesk.this, st3_MainActivity_Right.class);
                // Intent를 선언하여 해당 화면 전 액티비티로 연결해놓는다.
                startActivity(intent); // 인텐트를 통해 화면 이동
                finish();
            }
        });

        btn_hint_studentHint.setOnClickListener(new View.OnClickListener() { // 단서 버튼을 클릭한다면
            @Override
            public void onClick(View view) {
                if(st3_TryNumber.st3_ht2_try == 0) { // 만약 해당 단서를 처음 눌렀다면,
                    Toast.makeText(getApplicationContext(), "학생들이 주고받은 쪽지를 획득하셨습니다.", Toast.LENGTH_LONG).show();
                    // 일회성 토스트 메시지 출력
                    st3_TryNumber.st3_ht2_try++; // 그리고 이미 토스트 메시지를 읽었다고 알려준다.
                }
                // 토스트 메시지는 여러 번 출력할 수 없기 때문에 if문을 통해 통제했다.
                Intent intent = new Intent(st3_BG_StudentDesk.this, st3_Hint2_Student.class);
                // 토스트 메시지를 다 읽으면 화면을 이동한다. (책 이미지를 보여주기 위함)
                startActivity(intent);
                finish();
            }
        });
    }
}
