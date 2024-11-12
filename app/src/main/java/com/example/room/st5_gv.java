package com.example.room;

import android.app.Application;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class st5_gv extends Application {
    public static TextView st5_tv;
    public static InputStream st5_is;
    public static Scanner st5_sc;

    public static void viewText() {
        st5_gv.st5_sc = new Scanner(st5_gv.st5_is, "UTF-8");
        String ch = st5_gv.st5_sc.nextLine();
        st5_gv.st5_tv.setText(ch);
        st5_gv.st5_tv.setVisibility(View.VISIBLE);
    }

}
