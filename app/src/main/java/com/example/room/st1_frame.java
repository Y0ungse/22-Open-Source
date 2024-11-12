package com.example.room;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_frame extends AppCompatActivity {
    private Button btn_st1_moveDo;              ///문으로 이동 버튼
    private Button st1_frame_result;            /// 액자 클릭시 완성도 판단하는 버튼 ///
    private Button st1_scream;                  /// 숨겨져있던 탈출 버튼(완성된 그림) ///
    MediaPlayer st1_ending_media2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_frame);

        /// 상단바 제거 ///
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// hint 버튼 ///

        st1_gv.st1_hintBtn = (Button) findViewById(R.id.btn_st1_hint);
        st1_gv.st1_hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                ///hint 잔여개수 0개일 경우 실행x) (초기값 2)
                Intent intent = new Intent(st1_frame.this, st1_Popup_hint.class);
                if (st1_gv.st1_hint_count > 0) {
                    st1_gv.st1_hint_count--;
                    startActivity(intent);
                }
                else
                    Toast.makeText(st1_frame.this, "힌트는 더이상 없는 것 같다.", Toast.LENGTH_SHORT).show();
            }
        });

        ///문으로 이동///
        btn_st1_moveDo = findViewById(R.id.st1_fr_to_do);
        btn_st1_moveDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_frame.this, st1_door.class);
                startActivity(intent);
            }
        });

        ///액자 (탈출경로) (그림조각)///
        st1_scream = findViewById(R.id.st1_scream);
        st1_frame_result = findViewById(R.id.st1_frame_result);
        st1_frame_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /// 그림조각 다 있는지 check ///

                if (st1_gv.st1_pop1 && st1_gv.st1_pop2 && st1_gv.st1_pop3 && st1_gv.st1_pop4){      ///전역변수 다 true인지 check

                    Toast.makeText(st1_frame.this, "그림을 완성하자 문이 열렸다.", Toast.LENGTH_SHORT).show();  /// toast message ///
                    st1_scream.setVisibility(View.VISIBLE);             ///나가는 버튼 보여주기 (전체 그림) ///
                }
                /// 하나라도 부족시 실패. 메시지 하나만 보여주기 ///

                else {
                    Toast.makeText(st1_frame.this, "종이 조각 4개로 액자를 맞출 수 있겠는데?", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /// 액자 완성시 나오는 그림 ///

        st1_scream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st1_ending_media2 = MediaPlayer.create(st1_frame.this, R.raw.st1_keyofart);
                st1_ending_media2.start();

                Intent intent = new Intent(st1_frame.this, st1_StartAndEnding_Ending.class);
                startActivity(intent);
            }
        });
    }

    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}