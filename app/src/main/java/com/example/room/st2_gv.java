package com.example.room;

import android.app.Application;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class st2_gv extends Application {

    public static TextView tv;
    public static InputStream is;
    public static Scanner sc;


    public static void viewText() {
        st2_gv.sc = new Scanner(st2_gv.is, "UTF-8");
        String ch = st2_gv.sc.nextLine();
        st2_gv.tv.setText(ch);
        st2_gv.tv.setVisibility(View.VISIBLE);
    }
}