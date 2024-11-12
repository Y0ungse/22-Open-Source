package com.example.room;

import android.app.Application;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;


public class st3_gv extends Application { // 해당 java 파일은 res/raw에 있는 .txt를 읽기 위하여 선언한 java 파일이다.

    // xml과 링크해줄 변수들을 선언한다.
    public static InputStream st3_is; // st3_is 라는 변수는 .txt 파일에 있는 글자들을 받아올 InputStream 클래스의 변수이다.
    public static Scanner st3_sc; // st3_sc 라는 변수는 InputStream에서 받아온 텍스트들을 한 문장씩 가져올 Scanner 클래스 변수이다.
    public static TextView st3_tv; // txt로부터 오는 라인을 text 뷰에 띄울 변수이다.

    public static void viewText() {
        st3_gv.st3_sc = new Scanner(st3_gv.st3_is, "UTF-8");
        // InputStream에서 한 줄씩 받을 때, UTF-8로 인코딩하여 받을 것이라고 선언한다.
        String ch = st3_gv.st3_sc.nextLine();
        // Sting 변수는 sc의 한 줄씩 받아온다.
        st3_gv.st3_tv.setText(ch);
        // xml과 연결한 텍스트뷰에 ch 변수를 setText Method를 통해 띄운다.
        st3_gv.st3_tv.setVisibility(View.VISIBLE);
        // text view의 Visibility를 VISIBLE로 바꿔 User가 보이게 만든다.
    }

}

