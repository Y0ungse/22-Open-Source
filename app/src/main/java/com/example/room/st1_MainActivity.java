package com.example.room;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_MainActivity extends AppCompatActivity {
    private Button btn_st1_moveBp;          ///가방으로 이동
    private Button btn_st1_moveBB;          /// 칠판으로 이동
    private Button btn_st1_moveDesk;        /// 책상으로 이동
    private Button btn_st1_moveDoor;        /// 문으로 이동
    private Button btn_st1_moveLocker;      /// 사물함으로 이동
    private Button btn_st1_moveWindow;      /// 창문으로 이동


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_classroom);

        /// 상단바 제거 ///
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        /// hint 버튼 ///

        st1_gv.st1_hintBtn = (Button) findViewById(R.id.btn_st1_hint);
        st1_gv.st1_hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_Popup_hint.class);
                if (st1_gv.st1_hint_count > 0) {            ///hint 잔여개수 0개일 경우 실행x) (초기값 2)
                    st1_gv.st1_hint_count--;
                    startActivity(intent);
                }
                else
                    Toast.makeText(st1_MainActivity.this, "힌트는 더이상 없는 것 같다.", Toast.LENGTH_SHORT).show();
            }
        });

        /// item 버튼 ///
        st1_gv.st1_itemBtn = (Button) findViewById(R.id.btn_st1_item);
        st1_gv.st1_itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_Popup_item.class);
                startActivity(intent);
            }
        });

        ///가방으로 이동///
        btn_st1_moveBp = findViewById(R.id.st1_cl_to_bp);
        btn_st1_moveBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_backpack.class);
                startActivity(intent);
            }
        });

        ///칠판으로 이동///
        btn_st1_moveBB = findViewById(R.id.st1_cl_to_bb);
        btn_st1_moveBB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_blackboard.class);
                startActivity(intent);
            }
        });

        ///책상으로 이동///
        btn_st1_moveDesk = findViewById(R.id.st1_cl_to_de);
        btn_st1_moveDesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_desk.class);
                startActivity(intent);
            }
        });

        ///문으로 이동///
        btn_st1_moveDoor = findViewById(R.id.st1_cl_to_do);
        btn_st1_moveDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_door.class);
                startActivity(intent);
            }
        });

        ///사물함으로 이동///
        btn_st1_moveLocker = findViewById(R.id.st1_cl_to_lo);
        btn_st1_moveLocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_lockers.class);
                startActivity(intent);
            }
        });

        ///창틀로 이동///
        btn_st1_moveWindow = findViewById(R.id.st1_cl_to_wi);
        btn_st1_moveWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_MainActivity.this, st1_window.class);
                startActivity(intent);
            }
        });
    }
    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}