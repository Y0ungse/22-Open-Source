package com.example.room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class st3_Popup_QuizHint extends Activity {
    TextView tv_hint; // xml의 텍스트뷰와 link할 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 해당 액티비티에서 TITLE(앱 이름 창)을 없앤다.
        setContentView(R.layout.st3_popup_hint_form);
        // xml과 연결.

        tv_hint = (TextView) findViewById(R.id.st3_txt_hint);
        // 위에서 선언한 텍스트뷰 변수는 xml의 텍스트뷰와 id를 통해 연결한다.

        Intent intent = getIntent(); // intent를 새로 받는다.
        String data = intent.getStringExtra("data");
        // data는 String class의 instance, intent에게 String 변수를 전달할 것이다.
        tv_hint.setText(data);
        // 해당 텍스트뷰에 받아올 data를 기입한다.
    }

    // 화면 버튼을 클릭하면
    public void mOnClose(View v) {
        // 데이터를 전달할 것이다.
        Intent intent = new Intent();
        // 인텐트를 선언
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        finish(); // 팝업 액티비티를 종료
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 팝업 액티비티의 바깥 화면 클릭할 때도 안 닫히게끔 해야한다.
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE) {
            // 바깥 레이어를 클릭하면
            return false; // false값을 return
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        return; // 팝업창에서 안드로이드 핸드폰 백 버튼을 눌러도 안 닫히게끔.
    }
}
