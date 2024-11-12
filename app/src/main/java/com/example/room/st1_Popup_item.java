package com.example.room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class st1_Popup_item extends Activity {
    public static View st1_list_item1;
    public static View st1_list_item2;
    public static View st1_list_item3;
    public static View st1_list_item4;
    public static View st1_list_item5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_popup_item_form);

        st1_list_item1 = findViewById(R.id.st3_list_item1);
        st1_list_item2 = findViewById(R.id.st3_list_item2);
        st1_list_item3 = findViewById(R.id.st3_list_item3);
        st1_list_item4 = findViewById(R.id.st3_list_item4);
        st1_list_item5 = findViewById(R.id.st3_list_item5);

        if(st1_gv.st1_eraser)
            st1_list_item1.setVisibility(View.VISIBLE);

        if(st1_gv.st1_pop1)
            st1_list_item2.setVisibility(View.VISIBLE);

        if(st1_gv.st1_pop2)
            st1_list_item3.setVisibility(View.VISIBLE);

        if(st1_gv.st1_pop3)
            st1_list_item4.setVisibility(View.VISIBLE);

        if(st1_gv.st1_pop4)
            st1_list_item5.setVisibility(View.VISIBLE);

    }

    public void mOnClose(View v) {
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        return;
    }
}