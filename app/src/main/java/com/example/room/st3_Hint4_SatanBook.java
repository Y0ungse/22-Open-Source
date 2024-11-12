package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class st3_Hint4_SatanBook extends AppCompatActivity {

    // 단서를 보이는 액티비티에서 원래 화면으로 돌아갈 버튼을 만든다.
    Button btn_backHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_hint4_satan_book);// xml과 동기화
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_backHome = findViewById(R.id.st3_btn_hint4ToRoot);// 버튼 동기화
        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// 버튼을 누른다면
                Intent intent = new Intent(st3_Hint4_SatanBook.this, st3_BG_Cabinet.class);
                // 액티비티를 이동하는 Intent 선언
                startActivity(intent);// 새로운 액티비티 실행
                finish();// 기존 액티비티 종료
            }
        });
    }
}
