package com.example.room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class st1_Popup_hint extends Activity {
    TextView st1_tv_hint;               //hint textview
    private String st_str_hint;         /// 최적 힌트 저장하는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.st1_hint_layout);

        st1_tv_hint = (TextView) findViewById(R.id.st1_txt_hint);

        /// hint 최적 제공 ///
        if (st1_gv.st1_pop1 == false)               /// 종이조각1 발견x ///
            st_str_hint = st1_gv.st1_hint1;

        else if (st1_gv.st1_pop2 == false)          /// 종이조각2 발견x ///
            st_str_hint = st1_gv.st1_hint2;

        else if (st1_gv.st1_pop3 == false)          /// 종이조각3 발견x ///
            st_str_hint = st1_gv.st1_hint3;

        else if (st1_gv.st1_pop4 == false)          /// 종이조각4 발견x ///
            st_str_hint = st1_gv.st1_hint4;

        st1_tv_hint.setText(st_str_hint);          ///hint 만족하는 값 넣어서 textview로 보여주기 ///
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
