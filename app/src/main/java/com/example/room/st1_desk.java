package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_desk extends AppCompatActivity {
    private Button btn_st1_moveCl;              ///교실로 이동 버튼
    private Button btn_st1_getPOP2;             /// 종이조각2 획득 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_desk);

        /// 상단바 제거 ///

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// hint 버튼 ///

        st1_gv.st1_hintBtn = (Button) findViewById(R.id.btn_st1_hint);
        st1_gv.st1_hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {        ///hint 잔여개수 0개일 경우 실행x) (초기값 2)
                Intent intent = new Intent(st1_desk.this, st1_Popup_hint.class);
                if (st1_gv.st1_hint_count > 0) {
                    st1_gv.st1_hint_count--;
                    startActivity(intent);
                }
                else
                    Toast.makeText(st1_desk.this, "힌트는 더이상 없는 것 같다.", Toast.LENGTH_SHORT).show();
            }
        });

        /// item 버튼 ///
        st1_gv.st1_itemBtn = (Button) findViewById(R.id.btn_st1_item);
        st1_gv.st1_itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_desk.this, st1_Popup_item.class);
                startActivity(intent);
            }
        });

        ///교실로 이동///

        btn_st1_moveCl = findViewById(R.id.st1_de_to_cl);
        btn_st1_moveCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_desk.this, st1_MainActivity.class);
                startActivity(intent);
            }
        });

        ///종이조각2 획득///

        btn_st1_getPOP2 = findViewById(R.id.st1_pop2);
        btn_st1_getPOP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                ///전역변수 true로 + toast message 출력
                st1_gv.st1_pop2 = true;
                Toast.makeText(st1_desk.this, "종잇조각 2 획득", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}