package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_backpack extends AppCompatActivity {
    private Button btn_st1_moveCl;              ///교실로 이동
    private Button btn_st1_getEraser;           /// 지우개 획득 버튼
    private Button btn_st1_getPOP1;             /// 종이조각1 획득 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st1_backpack);

        /// hint 버튼 ///

        st1_gv.st1_hintBtn = (Button) findViewById(R.id.btn_st1_hint);
        st1_gv.st1_hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_backpack.this, st1_Popup_hint.class);
                if (st1_gv.st1_hint_count > 0) {           ///hint 잔여개수 0개일 경우 실행x) (초기값 2)
                    st1_gv.st1_hint_count--;
                    startActivity(intent);
                }
                else
                    Toast.makeText(st1_backpack.this, "힌트는 더이상 없는 것 같다.", Toast.LENGTH_SHORT).show();
            }
        });

        st1_gv.st1_itemBtn = (Button) findViewById(R.id.btn_st1_item);
        st1_gv.st1_itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_backpack.this, st1_Popup_item.class);
                startActivity(intent);
            }
        });



        ///교실로 이동///

        btn_st1_moveCl = findViewById(R.id.st1_bp_to_cl);
        btn_st1_moveCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_backpack.this, st1_MainActivity.class);
                startActivity(intent);
            }
        });

        ///칠판 지우개 획득///

        btn_st1_getEraser = findViewById(R.id.st1_eraser);
        btn_st1_getEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                                        ///전역변수 true로, toast message 출력
                st1_gv.st1_eraser = true;
                Toast.makeText(st1_backpack.this, "칠판 지우개 획득", Toast.LENGTH_SHORT).show();
            }
        });

        ///종이조각1 획득///

        btn_st1_getPOP1 = findViewById(R.id.st1_pop1);
        btn_st1_getPOP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                                ///전역변수 true로, toast message 출력
                st1_gv.st1_pop1 = true;
                Toast.makeText(st1_backpack.this, "종잇조각 1 획득", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}