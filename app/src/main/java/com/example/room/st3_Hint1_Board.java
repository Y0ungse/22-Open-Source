package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class st3_Hint1_Board extends AppCompatActivity {

    // 단서를 보이는 액티비티에서 원래 화면으로 돌아갈 버튼을 만든다.
    private Button btn_backHome;

    @Override
    protected void onCreate( Bundle savedInstanceState) { // 액티비티가 만들어지고,
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_hint1_board); // xml과 동기화
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_backHome = findViewById(R.id.st3_btn_boardToMain); // xml의 버튼과 해당 java의 버튼을 동기화시킨다.
        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 버튼을 누른다면
                Intent intent = new Intent(st3_Hint1_Board.this, st3_MainActivity.class);
                // 인텐트를 통해 액티비티 이동
                startActivity(intent);
                finish(); // 해당 액티비티를 종료시킨다.
            }
        });
    }
}
