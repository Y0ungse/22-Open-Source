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

public class st3_MainActivity_Left extends AppCompatActivity {
    // 해당 액티비티에서 사용할 버튼들을 선언해놓는다.
    private Button btn_moveL; // 왼쪽으로 가는 버튼
    private Button btn_moveR; // 오른쪽으로 가는 버튼
    private Button btn_toQuiz1; // Quiz를 풀러 가는 버튼
    private Button btn_toHint5; // 단서를 보여주는 버튼

    private Button btn_leftSKILL_hint;
    // 힌트를 사용하는 버튼 - 힌트는 횟수가 제한된 버튼이기에, SKILL이라는 칭을 붙였다.
    private Button btn_leftSKILL_item;
    // 아이템을 사용하는 버튼 - 아이템은 횟수가 제한되진 않았지만, 아이템창을 보여주는 특이한 버튼이기에 동일하게 SKILL이라는 명칭을 붙였다.

    private TextView txt_hint;
    // 해당 액티비티에서 스토리를 보여줄

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_activity_left); // xml과 동기화를 시킨다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // xml버튼과 java의 버튼을 동기화 시킨다.
        btn_leftSKILL_hint = findViewById(R.id.st3_btn_leftSKILL_hint);
        btn_leftSKILL_item = findViewById(R.id.st3_btn_leftSKILL_item);

        // 힌트를 넘겨줄 텍스트 뷰 또한 동기화.
        txt_hint = (TextView)findViewById(R.id.st3_txt_hint);

        // 첫 화면 켰을 때 스토리 라인, 스토리가 나올 땐 버튼을 숨긴다.
        if(st3_TryNumber.st3_left_try == 0) {
            st3_TryNumber.st3_left_try++; // 전역변수 컨트롤
            st3_gv.st3_is = getResources().openRawResource(R.raw.st3_left_storyline); // raw의 txt를 저장
            st3_gv.st3_sc = new Scanner(st3_gv.st3_is, "UTF-8");// 스캐너를 통해 저장한 텍스트를 읽을 단위
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_left_txt);// 텍스트를 텍스트뷰에 연동
            st3_gv.st3_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {// 텍스트뷰를 누르면
                    if(st3_gv.st3_sc.hasNextLine()) {// 다음 줄이 있다면 (공백이 아니면)
                        String storyLine = st3_gv.st3_sc.nextLine();// 해당 줄 받고
                        st3_gv.st3_tv.setText(storyLine); // 출력
                    }

                    else // 만약 다음 줄이 공백이면
                        st3_gv.st3_tv.setVisibility(View.GONE); // 텍스트뷰 안 보이게
                }
            });
        } else { // 이미 한번 읽었던 화면이라면,
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_left_txt); // 텍스트뷰 연동
            st3_gv.st3_tv.setVisibility(View.GONE);// 안 보이게
        }

        btn_moveL = findViewById(R.id.st3_btn_leftToRight); // 버튼을 동기화시킨다.
        btn_moveL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Left.this, st3_MainActivity_Right.class);
                // 실행시킬 새로운 액티비티를 intent를 통해 선언
                startActivity(intent); // 액티비티 첫 번째 화면으로 이동
                finish(); // 기존 액티비티 종료
            }
        });

        btn_leftSKILL_hint.setOnClickListener(new View.OnClickListener() { // 힌트 버튼을 누르면 일어나는 일
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Left.this, st3_Popup_QuizHint.class);

                if (st3_TryNumber.st3_htBtn_try == 0) { // 처음 사용하는 거라면,
                    st3_TryNumber.st3_htBtn_try++;
                    Toast.makeText(getApplicationContext(), "사용 가능한 횟수 2회 중 1회 사용하셨습니다.", Toast.LENGTH_LONG).show();

                    if(st3_TryNumber.st3_quiz1_solved == 0) { // Quiz1이 안 풀렸다면, quiz1의 힌트를 넘겨주기.
                        intent.putExtra("data", "HINT FOR QUIZ1\n\n\"캐비넷으로 가시오\"\n단서는 총 3개가 필요하다.\n단서의 빨간 글자를 잘 보아야 한다.\n\n\n> \'테스트 = #3\'으로 표현한다.\n> \'스\' = #3 중 2번째 즉, #3_2이다.");
                    } else { // Quiz1이 풀렸다는 뜻. quiz2의 힌트를 넘겨주자.
                        intent.putExtra("data", "HINT FOR QUIZ2\n\n\"과학실 문으로 가시오\"\n단서는 총 2개가 필요합니다.\n\n\n> number of luck\n    = 777\n> number of death\n    = 444\n> number of Satan\n    = ???");
                    }
                    startActivity(intent); // 팝업창 띄우기.

                } else if (st3_TryNumber.st3_htBtn_try == 1) { // 두 번째 사용하는 거라면,
                    st3_TryNumber.st3_htBtn_try++;
                    Toast.makeText(getApplicationContext(), "사용 가능한 횟수 2회 중 2회 사용하셨습니다.", Toast.LENGTH_LONG).show();

                    if(st3_TryNumber.st3_quiz1_solved == 0) { //Quiz1이 안 풀렸다면 quiz1의 힌트를 넘겨주기.
                        intent.putExtra("data", "HINT FOR QUIZ1\n\n\"캐비넷으로 가시오\"\n단서는 총 3개가 필요하다.\n단서의 빨간 글자를 잘 보아야 한다.\n\n\n> \'테스트 = #3\'으로 표현한다.\n> \'스\' = #3 중 2번째 즉, #3_2이다.");
                    } else { //Quiz1이 풀렸다는 뜻. quiz2의 힌트를 넘겨주자.
                        intent.putExtra("data", "HINT FOR QUIZ2\n\n\"과학실 문으로 가시오\"\n단서는 총 2개가 필요합니다.\n\n\n> number of luck\n    = 777\n> number of death\n    = 444\n> number of Satan\n    = ???");
                    }
                    startActivity(intent);

                } else { // 힌트를 다 사용했다면,
                    Toast.makeText(getApplicationContext(), "2회 모두 소진하여 사용하실 수 없습니다.", Toast.LENGTH_LONG).show();
                    // 토스트 메시지 출력. 사용할 수 없다.
                }
            }
        });

        btn_leftSKILL_item = findViewById(R.id.st3_btn_leftSKILL_item);
        btn_leftSKILL_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Left.this, st3_Popup_Item.class);
                startActivity(intent);
            }
        });

        btn_toHint5 = findViewById(R.id.st3_btn_toHint5);
        btn_toHint5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st3_TryNumber.st3_ht5_try == 0) {
                    Toast.makeText(getApplicationContext(), "피가 묻은 의문의 쪽지를 획득하셨습니다.", Toast.LENGTH_LONG).show();
                    st3_TryNumber.st3_ht5_try++;
                }
                Intent intent = new Intent(st3_MainActivity_Left.this, st3_Hint5_SatanNumber.class);
                // 실행시킬 새로운 액티비티를 intent를 통해 선언
                startActivity(intent); // 새로운 액티비티를 실행
                finish(); // 기존 액티비티 종료
            }
        });

        btn_toQuiz1 = findViewById(R.id.st3_btn_toQuiz1);
        btn_toQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Left.this, st3_Quiz1.class);
                // 실행시킬 새로운 액티비티를 intent를 통해 선언
                startActivity(intent); // 새로운 액티비티를 실행
                finish(); // 기존 액티비티 종료
            }
        });

        btn_moveR = findViewById(R.id.st3_btn_leftToCenter);
        btn_moveR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_MainActivity_Left.this, st3_MainActivity.class);
                // 실행시킬 새로운 액티비티를 intent를 통해 선언
                startActivity(intent); // 새로운 액티비티를 실행
                finish(); // 기존 액티비티 종료
            }
        });
    }
}
