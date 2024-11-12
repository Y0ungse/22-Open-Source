package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st3_Quiz1 extends AppCompatActivity {

    // xml과 연동할 버튼들.
    EditText et_quiz1Shell; // user의 정답을 입력할 EditText 변수를 선언
    Button btn_quiz1Input; // user의 입력한 정답을 건내줄 button 선언
    Button btn_quiz1ToRoot; // 퀴즈 화면에서 나가기 위한 버튼 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 해당 퀴즈 액티비티가 생성되고
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_quiz1_layout); // xml과 동기화를 시킨다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 위의 변수들을 xml에서 선언한 것들과 동기화를 시킨다.
        et_quiz1Shell = findViewById(R.id.st3_et_quiz1Shell);// edit text 동기화
        btn_quiz1Input = findViewById(R.id.st3_btn_quiz1Input);// 버튼 동기화
        btn_quiz1ToRoot = findViewById(R.id.st3_btn_quiz1ToRoot);// 버튼 동기화

        if(st3_TryNumber.st3_quiz1_solved == 0) {
            // 만약 quiz1_solved == 0인 경우 (문제를 맞추지 않았던 경우), -> 구체적인 설명은 st3_gv로 이동하여 확인이 가능하다.
            st3_gv.st3_is = getResources().openRawResource(R.raw.st3_quiz1_storyline); // rqw에 있는 스토리 라인(.txt) 갖고오기
            st3_gv.st3_sc = new Scanner(st3_gv.st3_is, "UTF-8"); // Scanner로 해당 .txt의 각각의 문장 받기
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_txt_quiz1);  // 텍스트뷰를 동기화시킨다.
            st3_gv.st3_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { // 사용자가 텍스트뷰창을 클릭할 때마다,
                    if(st3_gv.st3_sc.hasNextLine()) { // txt 파일에 다음 줄이 공백이 아니라면,
                        String storyLine = st3_gv.st3_sc.nextLine(); // 다음 줄을 저장하고
                        st3_gv.st3_tv.setText(storyLine); // 저장한 줄을 출력
                    }
                    else
                        st3_gv.st3_tv.setVisibility(View.GONE); // 다음 줄이 공백인 마지막 줄이면 텍스트뷰 삭제
                }
            });

            btn_quiz1Input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { // 답안을 제출하는 버튼을 누르면,
                    String str = ""; // EditText에 사용자가 입력한 답안을 가져오기 위한 String 변수.
                    str = et_quiz1Shell.getText().toString(); // str 변수에 EditText에 입력한 값으로 pointer 지정.

                    // 내가 설정한 답안은 "GOD"라는 값.
                    /*
                        만약 3글자 보다 적거나 많으면 -> 글자수를 맞추라고, String 비교이므로 공백을 없애라고 말해준다.
                        3글자인데 해답이 아니라면 -> 자물쇠가 열리지 않았다고 말해준다.
                     */
                    if(str.length() == 3) { // 만약 3글자이면,
                        if(str.equals("GOD")) { // 만약 답안과 같다면,
                            Toast.makeText(st3_Quiz1.this, "캐비넷 문이 열렸습니다.", Toast.LENGTH_SHORT).show();
                            // 1회성 토스트 메세지 출력
                            st3_TryNumber.st3_quiz1_solved++;
                            // 전역변수를 1 추가해주며 이미 풀었다고 알려준다.
                            Intent intent = new Intent(st3_Quiz1.this, st3_BG_Cabinet.class);
                            // 캐비넷으로 보이는 액티비티를 선언
                            startActivity(intent); // 새로운 액티비티 실행
                            finish(); // 기존 액티비티 종료
                        } else {    // 만약 3글자이긴한데 답안과 같지 않다면,
                            Toast.makeText(st3_Quiz1.this, "자물쇠가 열리지 않았다.", Toast.LENGTH_SHORT).show();
                            // 열리지 않았다고 토스트 메세지 출력
                        }
                    } else { // 만약 3글자가 아니라면
                        Toast.makeText(st3_Quiz1.this, "비밀번호는 3자리이다.(공백은 없애자)", Toast.LENGTH_SHORT).show();
                        // 공백 없애라고, 글자 다르다고 토스트 메세지 출력
                    }
                }
            });

            btn_quiz1ToRoot.setOnClickListener(new View.OnClickListener() { // 원래 화면으로 돌아가는 버튼을 누른다면
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(st3_Quiz1.this, st3_MainActivity_Left.class); // 원래 화면이었던 액티비티를 선언
                    startActivity(intent); // 새로운 액티비티 실행
                    finish(); // 기존 액티비티 종료
                }
            });

        } else { // 기존에 퀴즈를 풀었다면 (quiz1solved == 1인 경우), 텍스트 뷰가 그만 보이게 만들고, 다시 문제를 풀 필요가 없다..
            st3_gv.st3_tv = (TextView) findViewById(R.id.st3_txt_quiz1);
            st3_gv.st3_tv.setVisibility(View.GONE); // 텍스트뷰 숨기기

            // 바로 캐비넷으로 가는 액티비티를 실행시킨다.
            Intent intent = new Intent(st3_Quiz1.this, st3_BG_Cabinet.class);
            startActivity(intent);
            finish();
        }
    }
}
