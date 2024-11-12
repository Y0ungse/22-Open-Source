package com.example.room;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class st5_quiz_2 extends AppCompatActivity {
    private Button st5_btn_changetv;
    ImageView st5_img_tv;
    int st5_count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st5_quiz2);


        st5_btn_changetv = findViewById(R.id.st5_btn_changetv);
        st5_img_tv = findViewById(R.id.st5_img_tv);

        st5_btn_changetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (st5_count % 11 == 4) { //count % 11의 나머지 값이 4라면
                    st5_img_tv.setImageResource(R.drawable.st5_tv_empty_3); //empty3 출력
                }
                else if (st5_count % 11 == 8) { //count % 11의 나머지 값이 8이라면
                    st5_img_tv.setImageResource(R.drawable.st5_tv_empty_4); //empty4 출력
                }
                else if (st5_count % 11 == 10) { //count % 11의 나머지 값이 10이라면
                    st5_img_tv.setImageResource(R.drawable.st5_tv_hint); //hint 출력
                }
                else { //그외
                    st5_img_tv.setImageResource(R.drawable.st5_tv_empty_2); //empty2 출력
                }
                st5_count++; //버튼 클릭시 count++
            }
        });
    }
}