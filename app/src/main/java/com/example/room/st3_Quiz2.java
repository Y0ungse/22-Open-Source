package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st3_Quiz2 extends AppCompatActivity {

    // xml과 연동할 버튼들.
    EditText et_quiz2Shell;// user의 정답을 입력할 EditText 변수를 선언
    Button btn_quiz2Input;// user의 입력한 정답을 건내줄 button 선언
    Button btn_quiz2ToRoot;// 퀴즈 화면에서 나가기 위한 버튼 선언


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {// 해당 퀴즈 액티비티가 생성되고
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_quiz2_layout); // xml과 동기화를 시킨다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 위의 변수들을 xml에서 선언한 것들과 동기화를 시킨다.
        et_quiz2Shell = findViewById(R.id.st3_et_quiz2Shell); // edit text 동기화
        btn_quiz2Input = findViewById(R.id.st3_btn_quiz2Input);// 버튼 동기화
        btn_quiz2ToRoot = findViewById(R.id.st3_btn_quiz2ToRoot);// 버튼 동기화

        st3_gv.st3_is = getResources().openRawResource(R.raw.st3_quiz2_storyline); // rqw에 있는 스토리 라인(.txt 파일) 갖고오기
        st3_gv.st3_sc = new Scanner(st3_gv.st3_is, "UTF-8");
        st3_gv.st3_tv = (TextView) findViewById(R.id.st3_txt_quiz2);
        st3_gv.st3_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st3_gv.st3_sc.hasNextLine()) {
                    String storyLine = st3_gv.st3_sc.nextLine();
                    st3_gv.st3_tv.setText(storyLine);
                }
                else
                    st3_gv.st3_tv.setVisibility(View.GONE);
                }
        });

        btn_quiz2Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                str = et_quiz2Shell.getText().toString();

                if (str.length() == 3) {
                    if(str.equals("666")) {
                        Intent intent = new Intent(st3_Quiz2.this, st3_StartAndEnding_Ending.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(st3_Quiz2.this, "자물쇠가 열리지 않았다.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(st3_Quiz2.this, "비밀번호는 3자리이다.(공백은 없애자)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_quiz2ToRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st3_Quiz2.this, st3_MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
