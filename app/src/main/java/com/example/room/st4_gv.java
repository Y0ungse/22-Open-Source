package com.example.room;


import android.app.Application;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class st4_gv extends Application {
    public static TextView st4_tv;
    public static InputStream st4_is;
    public static Scanner st4_sc;

    public static void viewText() {
        st4_gv.st4_sc = new Scanner(st4_gv.st4_is, "MS949");
        String ch = st4_gv.st4_sc.nextLine();
        st4_gv.st4_tv.setText(ch);
        st4_gv.st4_tv.setVisibility(View.VISIBLE);
    }
}
