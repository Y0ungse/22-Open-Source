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

public class st3_MainActivity extends AppCompatActivity {

    // 사용할 버튼들 선언
    private Button btn_moveR;
    private Button btn_moveL;
    private Button btn_toTeacherDesk;
    private Button btn_boardHint;
    private Button btn_toQuiz2;

    private Button btn_centerSKILL_hint;
    private Button btn_centerSKILL_item;

    private TextView txt_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st3_activity_main);

        txt_hint = (TextView)findViewById(R.id.st3_txt_hint); // 힌트 버튼을 눌렀을 때 나타날 팝업 액티비티의 텍스트 뷰

        // 버튼 링크
        btn_moveL = findViewById(R.id.st3_btn_centerToLeft);  // 좌로 이동 버튼
        btn_moveR = findViewById(R.id.st3_btn_centerToRight); // 우로 이동 버튼

        btn_boardHint = findViewById(R.id.st3_btn_hint_board); // 보드 단서로 넘어가는 버튼
        btn_toQuiz2 = findViewById(R.id.st3_btn_center_Quiz2); // 퀴즈2로 넘어가는 버튼

        btn_centerSKILL_hint = findViewById(R.id.st3_btn_centerSKILL_hint); // 힌트 버튼 나타낼 버튼
        btn_centerSKILL_item = findViewById(R.id.st3_btn_centerSKILL_item); // 아이템 버튼 나타낼 버튼

        startService(new Intent(getApplicationContext(), st3_MusicService.class));

        if(st3_TryNumber.st3_center_try == 0) { // 해당 화면의 onCreate() 함수 바로 아래에 작성.
            // 0이라는 뜻은 onCreate가 처음으로 일어났다는 것. 따라서 text(스토리)를 보여줘야한다.
            st3_TryNumber.st3_center_try++; // 전역변수 컨트롤

            st3_gv.st3_is = getResources().openRawResource(R.raw.st3_center_storyline); // raw의 txt를 저장
            st3_gv.st3_sc = new Scanner(st3_gv.st3_is, "UTF-8"); // 스캐너를 통해 저장한 텍스트를 읽을 단위
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_txt_center_story); // 텍스트를 텍스트뷰에 연동
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
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_txt_center_story); // 텍스트뷰 연동
            st3_gv.st3_tv.setVisibility(View.GONE); // 안 보이게
        }

//        startService(new Intent(getApplicationContext(), MusicService.class)); // 노래 시작

        btn_moveL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity.this, st3_MainActivity_Left.class);
                // 실행시킬 새로운 액티비티를 intent를 통해 선언
                startActivity(intent); // 새로운 액티비티 실행
                finish();// 기존 액티비티 종료
            }
        });


        btn_centerSKILL_hint.setOnClickListener(new View.OnClickListener() { // 힌트 버튼을 누르면 일어나는 일
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity.this, st3_Popup_QuizHint.class);
                // intent를 미리 선언해놓는다. (밑에 case들은 전부 다 같은 intent를 실행할 것이기 때문)

                if (st3_TryNumber.st3_htBtn_try == 0) { // try가 0이다 = 처음 사용하는 거라면,
                    st3_TryNumber.st3_htBtn_try++; // 한번 봤다고 표시.
                    Toast.makeText(getApplicationContext(), "사용 가능한 횟수 2회 중 1회 사용하셨습니다.", Toast.LENGTH_LONG).show();
                    // 이벤트성 토스트 메시지를 출력. "2회 중 1회 사용했다."

                    if(st3_TryNumber.st3_quiz1_solved == 0) { // Quiz1이 안 풀렸다면, quiz1의 힌트를 넘겨주기.
                        intent.putExtra("data", "HINT FOR QUIZ1\n\n\"캐비넷으로 가시오\"\n단서는 총 3개가 필요하다.\n단서의 빨간 글자를 잘 보아야 한다.\n\n\n> #뒤의 숫자는 글자 수를 나타낸다.\n> 예를 들어 네 글자중 두 번째 자리는 #4_2로 표현할 수 있다.");
                        // putExtra를 통해 Dialog 힌트에 텍스트 값을 전해준다.
                    } else { // Quiz1이 풀렸다는 뜻. quiz2의 힌트를 넘겨주자.
                        intent.putExtra("data", "HINT FOR QUIZ2\n\n\"문으로 가시오\"\n단서는 총 2개가 필요하다.\n\n\n> number of luck\n    = 777\n> number of death\n    = 444\n> number of Satan\n    = ???");
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
                        intent.putExtra("data", "HINT FOR QUIZ2\n\n최후의 퀴즈.\n단서는 총 2개가 필요합니다.\n\n\n> number of luck\n    = 777\n> number of death\n    = 444\n> number of Satan\n    = ???");
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


        btn_centerSKILL_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity.this, st3_Popup_Item.class);
                startActivity(intent);
            }
        });



        // -----------버튼을 눌렀을 때 나오게 할 액티비티들------------
        btn_moveR.setOnClickListener(new View.OnClickListener() { // 오른쪽 이동 버튼을 누르면
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity.this, st3_MainActivity_Right.class);// 이동할 액티비티를 Intent를 통해 선언
                startActivity(intent); // 새로운 액티비티 실행
                finish(); // 기존 액티비티 종료
            }
        });

        btn_toQuiz2.setOnClickListener(new View.OnClickListener() { // 퀴즈 버튼 누르면
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity.this, st3_Quiz2.class); // 이동할 액티비티를 Intent를 통해 선언
                startActivity(intent); // 새로운 액티비티를 실행
                finish(); // 기존 액티비티 종료
            }
        });

        btn_toTeacherDesk = findViewById(R.id.st3_btn_hint1); // 선생님 책상 버튼 누르면
        btn_toTeacherDesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity.this, st3_BG_TeacherDesk.class);// 이동할 액티비티를 Intent를 통해 선언
                startActivity(intent); // 선생님 책상 액티비티 이동
                finish(); // 기존 액티비티 종료
            }
        });

        btn_boardHint.setOnClickListener(new View.OnClickListener() { // 칠판 누르면
            @Override
            public void onClick(View view) {
                if(st3_TryNumber.st3_ht1_try == 0) { // 변수가 0이라는 것은 처음본다는 것.
                    st3_TryNumber.st3_ht1_try++; // 변수에 1을 추가해줌으로써 이미 봤다는 표시.
                    Toast.makeText(getApplicationContext(), "주기율표.. 화학 시간에 잤던 내가 밉다.", Toast.LENGTH_LONG).show();
                    // 1회용 이벤트성 토스트 메시지 출력
                }
                Intent intent = new Intent(st3_MainActivity.this, st3_Hint1_Board.class); //이동할 액티비티를 intent를 통해 선언
                startActivity(intent); // 새로운 액티비티 실행
                finish(); // 기존 액티비티 종료
            }
        });



    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(getApplicationContext(), st3_MusicService.class));
        super.onDestroy();
    }
}
