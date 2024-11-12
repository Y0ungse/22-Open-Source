package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class st3_BG_Cabinet extends AppCompatActivity {

    // .java 안에서 쓸 버튼 선언
    private Button btn_backHome;
    private Button btn_toHint4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_activity_cabinet);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_backHome = findViewById(R.id.st3_btn_cabinetToRoot); // 뒤로가기 버튼을 xml과 링크시켜주고
        btn_backHome.setOnClickListener(new View.OnClickListener() { // 만약 해당 버튼을 누른다면,
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_BG_Cabinet.this, st3_MainActivity_Left.class); // Intent 선언
                startActivity(intent); // 위의 선언했던 인텐트를 통해 해당 캐비넷을 들어오기 전의 화면으로 이동
                finish();
            }
        });

        btn_toHint4 = findViewById(R.id.st3_btn_toHint4); // 단서 버튼을 링크 시킨다.
        btn_toHint4.setOnClickListener(new View.OnClickListener() { // 단서 버튼을 누르면
            @Override
            public void onClick(View view) {
                if(st3_TryNumber.st3_ht4_try == 0) { // 만약 단서 버튼을 처음 눌렀다면,
                    st3_TryNumber.st3_ht4_try++; // ++을 해줌으로써 전역변수에 처음 누른 것이 아니라는 것을 알린 뒤,
                    Toast.makeText(getApplicationContext(), "사탄에 관한 책 아이템을 획득하셨습니다.", Toast.LENGTH_SHORT).show();
                    // 이벤트성 토스트 메시지 출력
                }
                // 만약 st3_TryNumber.st3_ht4_try가 0보다 큰 상태라면, 이미 눌렀다는 뜻이므로, 토스트 메시지를 출력할 필요가 없다.
                Intent intent = new Intent(st3_BG_Cabinet.this, st3_Hint4_SatanBook.class); // intent 선언
                startActivity(intent); // 화면 이동
                finish();
            }
        });
    }
}
