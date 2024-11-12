package com.example.room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class st3_Popup_Item extends Activity {
    // item창에서 띄울 View는 총 5개 -> Stage에는 총 5개의 단서가 drop되기 때문에 5개만 정의하였다.
    public static View st3_list_item1;
    public static View st3_list_item2;
    public static View st3_list_item3;
    public static View st3_list_item4;
    public static View st3_list_item5;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // 해당 액티비티가 생성되면
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st3_popup_item_form); // item과 관련된 xml과 연동 (힌트와 같은 메커니즘)

        // 각 java 안의 View를 xml View와 동기화시킨다.
        st3_list_item1 = findViewById(R.id.st3_list_item1);
        st3_list_item2 = findViewById(R.id.st3_list_item2);
        st3_list_item3 = findViewById(R.id.st3_list_item3);
        st3_list_item4 = findViewById(R.id.st3_list_item4);
        st3_list_item5 = findViewById(R.id.st3_list_item5);

        /*
        기본적으로 htx_try == 0 이라는 것은 user가 해당 단서를 클릭하지 않았다는 뜻이다.
        따라서 0이라면 item창에 있는 해당 단서의 view를 띄울 필요가 없다.
        반대로 >0이라면 user가 단서를 1번 이상 클릭했다는 것.
        따라서 이 상황에선 item창에 해당 단서를 띄워야한다.
        이것을 VISIBLE로 control하기로 했다.
         */
        if(st3_TryNumber.st3_ht1_try > 0) // 눌렀으면
            st3_list_item1.setVisibility(View.VISIBLE); // View를 보이게

        if(st3_TryNumber.st3_ht2_try > 0) // 눌렀으면
            st3_list_item2.setVisibility(View.VISIBLE); // 보이게

        if(st3_TryNumber.st3_ht3_try > 0)
            st3_list_item3.setVisibility(View.VISIBLE);

        if(st3_TryNumber.st3_ht4_try > 0)
            st3_list_item4.setVisibility(View.VISIBLE);

        if(st3_TryNumber.st3_ht5_try > 0)
            st3_list_item5.setVisibility(View.VISIBLE);

    }

    public void mOnClose(View v) { // 팝업 액티비티의 아래 확인 버튼을 누르면
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup"); // 팝업창을 닫는다.
        setResult(RESULT_OK, intent);

        finish(); // 해당 액티비티를 아예 종료.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE) { // 팝업 액티비티의 바깥쪽을 눌러도 꺼지지 않는다.
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
