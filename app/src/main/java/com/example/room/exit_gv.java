package com.example.room;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.Scanner;

public class exit_gv extends AppCompatActivity {

    public static TextView exit_tv;
    public static InputStream exit_is;
    public static Scanner exit_sc;

    public static void viewText() {
        exit_gv.exit_sc = new Scanner(exit_gv.exit_is, "UTF-8");
        String ch = exit_gv.exit_sc.nextLine();
        exit_gv.exit_tv.setText(ch);
        exit_gv.exit_tv.setVisibility(View.VISIBLE);
    }
}
