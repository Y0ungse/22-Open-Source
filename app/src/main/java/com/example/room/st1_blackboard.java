package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_blackboard extends AppCompatActivity {
    private Button btn_st1_moveCl;          ///교실로 이동 버튼
    private Button btn_st1_moveLD;          /// 교탁으로 이동 버튼
    private Button btn_st1_bb_letter;       /// 칠판 클릭 버튼 ///
    private ImageView st1_hidden_board;     /// 숨겨져있던 칠판 이미지뷰 ///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_blackboard);

        /// 상단바 제거 ///

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// hint 버튼 ///

        st1_gv.st1_hintBtn = (Button) findViewById(R.id.btn_st1_hint);
        st1_gv.st1_hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_blackboard.this, st1_Popup_hint.class);
                if (st1_gv.st1_hint_count > 0) {        ///hint 잔여개수 0개일 경우 실행x) (초기값 2)
                    st1_gv.st1_hint_count--;
                    startActivity(intent);
                }
                else
                    Toast.makeText(st1_blackboard.this, "힌트는 더이상 없는 것 같다.", Toast.LENGTH_SHORT).show();
            }
        });

        /// item 버튼 ///
        st1_gv.st1_itemBtn = (Button) findViewById(R.id.btn_st1_item);
        st1_gv.st1_itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_blackboard.this, st1_Popup_item.class);
                startActivity(intent);
            }
        });

        /// 교실로 이동 ///

        btn_st1_moveCl = findViewById(R.id.st1_bb_to_cl);
        btn_st1_moveCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_blackboard.this, st1_MainActivity.class);
                startActivity(intent);
            }
        });

        /// 교탁 서랍으로 이동 ///

        btn_st1_moveLD = findViewById(R.id.st1_bb_to_ld);
        btn_st1_moveLD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_blackboard.this, st1_lectureDesk.class);
                startActivity(intent);
            }
        });

        /// 칠판 클릭 ///

        st1_hidden_board = findViewById(R.id.st1_hiddenboard);              /// 숨겨져있던 칠판 이미지 ///
        btn_st1_bb_letter = findViewById(R.id.st1_bb_letter);               /// 칠판 클릭 버튼 ///
        btn_st1_bb_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //분필 지우개 없을때                                /// 지우개 획득x  == 전역변수 false
                if(st1_gv.st1_eraser == false)
                    Toast.makeText(st1_blackboard.this, "분필들이 다 부러져있다. 힘이 센 사람이 쓴걸까?", Toast.LENGTH_SHORT).show();

                //분필 지우개 있을때
                else{                                               /// 지우개 획득o  == 전역변수 true
                    Toast.makeText(st1_blackboard.this, "전에 눌러쓴 글씨가 나타났다.", Toast.LENGTH_SHORT).show();
                    st1_hidden_board.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}