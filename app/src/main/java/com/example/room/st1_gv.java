package com.example.room;

import android.app.Application;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class st1_gv extends Application {
    public static Button st1_itemBtn;                           ///item 아직 연결안되서 구현아직 안됨///
    public static Button st1_hintBtn;                           /// stage1 hint 버튼 ///
    public static TextView st1_tv;                              /// st1 textview 받는 변수 ///
    public static InputStream st1_is;                           /// Input System ///
    public static Scanner st1_sc;                               ///     Scanner ///
    public static int st1_hint_count = 4;                       /// st1 hint 개수 count 변수 ///
    public static Boolean st1_pop1 = false;                     /// 종이조각 전역변수 ///
    public static Boolean st1_pop2 = false;                     /// 종이조각 전역변수 ///
    public static Boolean st1_pop3 = false;                     /// 종이조각 전역변수 ///
    public static Boolean st1_pop4 = false;                     /// 종이조각 전역변수 ///
    public static Boolean st1_eraser = false;                   ///  지우개  전역변수 ///


    /// hint ///
    public static String st1_hint1 = "교실에 누군가 가방을 두고 간듯하다. 가방을 살펴보자.";
    public static String st1_hint2 = "누군가 책상 서랍에 무언가를 두고 간듯하다.";
    public static String st1_hint3 = "칠판 앞 교탁 서랍 안에 무언가 있지 않을까?";
    public static String st1_hint4 = "꽃의 개수가 다른데 무슨 의미가 있을까...?";


    /// text 읽는 메소드 ///
    public static void viewText(){
        st1_gv.st1_sc = new Scanner(st1_gv.st1_is, "MS949");
        String ch = st1_gv.st1_sc.nextLine();
        st1_gv.st1_tv.setText(ch);
        st1_gv.st1_tv.setVisibility(View.VISIBLE);

    }
}