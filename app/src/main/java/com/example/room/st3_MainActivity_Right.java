package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st3_MainActivity_Right extends AppCompatActivity {

    // 해당 액티비티에서 사용할 버튼들을 선언해놓는다.
    private Button btn_moveL; // 왼쪽으로 갈 버튼
    private Button btn_moveR; // 오른쪽으로 갈 버튼
    private Button btn_toHint; // 단서로 가는 버튼

    private Button btn_rightSKILL_hint; // 힌트 버튼
    private Button btn_rightSKILL_item; // 아이템 버튼

    private TextView txt_hint; // 힌트를 위한 텍스트뷰


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_activity_right);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_rightSKILL_hint = findViewById(R.id.st3_btn_rightSKILL_hint);// hint 버튼과 링크
        btn_rightSKILL_item = findViewById(R.id.st3_btn_rightSKILL_item);// 아이 버튼과 링크
        txt_hint = (TextView)findViewById(R.id.st3_txt_hint); // 힌트를 넘겨줄 텍스트 뷰를 링크

        // 맵에 설치된 힌트를 위한 변수를 xml과 link.
        btn_toHint = findViewById(R.id.st3_btn_hint2);

        // 시점 이동을 위한 변수들을 xml의 버튼들과 link 시킨다.
        btn_moveL = findViewById(R.id.st3_btn_rightToCenter);
        btn_moveR = findViewById(R.id.st3_btn_rightToLeft);

        if(st3_TryNumber.st3_right_try == 0) { // 해당 화면에 대한 전역변수가 0이다 = 처음으로 화면을 열어본다.
            st3_TryNumber.st3_right_try++; // 전역변수 1 추가 -> 이미 본 적이 있게 된다.
            st3_gv.st3_is = getResources().openRawResource(R.raw.st3_right_storyline);// raw의 txt를 저장
            st3_gv.st3_sc = new Scanner(st3_gv.st3_is, "UTF-8"); // 스캐너를 통해 저장한 텍스트를 읽을 단위
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_right_txt); // 텍스트를 텍스트뷰에 연동
            st3_gv.st3_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { // 텍스트뷰를 누르면
                    if(st3_gv.st3_sc.hasNextLine()) { // 다음 줄이 있다면 (공백이 아니면)
                        String storyLine = st3_gv.st3_sc.nextLine(); // 해당 줄 받고
                        st3_gv.st3_tv.setText(storyLine); // 출력
                    }

                    else // 만약 다음 줄이 공백이면
                        st3_gv.st3_tv.setVisibility(View.GONE); // 텍스트뷰 안 보이게
                }
            });
        } else { // 이미 한번 읽었던 화면이라면,
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_right_txt); // 텍스트뷰 연동
            st3_gv.st3_tv.setVisibility(View.GONE); // 안 보이게
        }

        btn_toHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Right.this, st3_BG_StudentDesk.class);
                // 실행시킬 새로운 액티비티를 intent를 통해 선언
                startActivity(intent); // 새로운 액티비티 실행
                finish(); // 기존 액티비티 종료
            }
        });

        btn_moveL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Right.this, st3_MainActivity.class);
                // 실행시킬 새로운 액티비티를 intent를 통해 선언
                startActivity(intent); // 새로운 액티비티 실행
                finish(); // 기존 액티비티 종료
            }
        });

        btn_rightSKILL_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Right.this, st3_Popup_QuizHint.class);
                // intent를 미리 선언해놓는다. (밑에 case들은 전부 다 같은 intent를 실행할 것이기 때문)

                if (st3_TryNumber.st3_htBtn_try == 0) { // try가 0이다 = 처음 사용하는 거라면,
                    st3_TryNumber.st3_htBtn_try++; // 한번 봤다고 표시.
                    Toast.makeText(getApplicationContext(), "사용 가능한 횟수 2회 중 1회 사용하셨습니다.", Toast.LENGTH_LONG).show();
                    // 이벤트성 토스트 메시지를 출력. "2회 중 1회 사용했다."

                    if(st3_TryNumber.st3_quiz1_solved == 0) { // Quiz1이 안 풀렸다면, quiz1의 힌트를 넘겨주기.
                        intent.putExtra("data", "HINT FOR QUIZ1\n\n\"캐비넷으로 가시오\"\n단서는 총 3개가 필요하다.\n단서의 빨간 글자를 잘 보아야 한다.\n\n\n> \'테스트 = #3\'으로 표현한다.\n> \'스\' = #3 중 2번째 즉, #3_2이다.");
                        // putExtra를 통해 Dialog 힌트에 텍스트 값을 전해준다.
                    } else { // Quiz1이 풀렸다는 뜻. quiz2의 힌트를 넘겨주자.
                        intent.putExtra("data", "HINT FOR QUIZ2\n\n\"과학실 문으로 가시오\"\n힌트는 총 2개가 필요합니다.\n\n\n> number of luck\n    = 777\n> number of death\n    = 444\n> number of Satan\n    = ???");
                        // putExtra를 통해 Dialog 힌트에 텍스트 값을 전해준다.
                    }
                    startActivity(intent); // 팝업창 띄우기.

                } else if (st3_TryNumber.st3_htBtn_try == 1) { // 두 번째 사용하는 거라면,
                    st3_TryNumber.st3_htBtn_try++; // 2로 전환 -> 2회 중 2회 봤다는 뜻.
                    Toast.makeText(getApplicationContext(), "사용 가능한 횟수 2회 중 2회 사용하셨습니다.", Toast.LENGTH_LONG).show();
                    // 이벤트성 토스트 메시지 출력. " 2회 중 2회 사용했다."

                    if(st3_TryNumber.st3_quiz1_solved == 0) { //Quiz1이 안 풀렸다면 quiz1의 힌트를 넘겨주기.
                        intent.putExtra("data", "HINT FOR QUIZ1\n\n\"캐비넷으로 가시오\"\n단서는 총 3개가 필요하다.\n단서의 빨간 글자를 잘 보아야 한다.\n\n\n> \'테스트 = #3\'으로 표현한다.\n> \'스\' = #3 중 2번째 즉, #3_2이다.");
                        // putExtra를 통해 Dialog 힌트에 텍스트 값을 전해준다.
                    } else { //Quiz1이 풀렸다는 뜻. quiz2의 힌트를 넘겨주자.
                        intent.putExtra("data", "HINT FOR QUIZ2\n\n\"과학실 문으로 가시오\"\n힌트는 총 2개가 필요합니다.\n\n\n> number of luck\n    = 777\n> number of death\n    = 444\n> number of Satan\n    = ???");
                        // putExtra를 통해 Dialog 힌트에 텍스트 값을 전해준다.
                    }
                    startActivity(intent);
                    // 팝업창 인텐트 실행

                } else { // 힌트를 다 사용했다면,
                    Toast.makeText(getApplicationContext(), "2회 모두 소진하여 사용하실 수 없습니다.", Toast.LENGTH_LONG).show();
                    // 토스트 메시지만 보여주고 끝. 힌트를 볼 수 없게 intent를 하지 않는다.
                }
            }
        });

        btn_rightSKILL_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Right.this, st3_Popup_Item.class);
                startActivity(intent);
            }
        });


        btn_moveR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Right.this, st3_MainActivity_Left.class);
                startActivity(intent); // 새로운 액티비티를 실행
                finish(); // 기존 액티비티 종료
            }
        });
    }
}
