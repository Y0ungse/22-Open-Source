package com.example.room;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class st2_paint extends AppCompatActivity {

    class Point{
        float st2_x;
        float st2_y;
        boolean st2_check;
        int st2_color;

        public Point(float x, float y, boolean check,int color)
        {
            this.st2_x = x;
            this.st2_y = y;
            this.st2_check = check;
            this.st2_color = color;
        }
    }

    class MyView extends View
    {
        public MyView(Context context) { super(context); }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint p = new Paint();
            p.setStrokeWidth(15);
            for(int i=1 ; i<points.size() ; i++)
            {
                p.setColor(points.get(i).st2_color);
                if(!points.get(i).st2_check)
                    continue;
                canvas.drawLine(points.get(i-1).st2_x,points.get(i-1).st2_y,points.get(i).st2_x,points.get(i).st2_y,p);
            }
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float st2_x = event.getX();
            float st2_y = event.getY();

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    points.add(new Point(st2_x,st2_y,false , st2_color));
                case MotionEvent.ACTION_MOVE :
                    points.add(new Point(st2_x,st2_y,true , st2_color));
                    break;
                case MotionEvent.ACTION_UP :
                    break;
            }
            invalidate();
            return true;
        }
    }

    ArrayList<Point> points = new ArrayList<Point>();
    Button st2_clearbtn, st2_btn_submit;
    LinearLayout st2_drawlinear;
    int st2_color = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_paint);

        final MyView m = new MyView(this);
        /* ----- 색 변경 ------ */
        findViewById(R.id.st2_btn_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st2_color = Color.RED ;
            }
        });
        findViewById(R.id.st2_btn_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st2_color = Color.BLUE ;
            }
        });
        findViewById(R.id.st2_btn_black).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st2_color = Color.BLACK ;
            }
        });

        st2_clearbtn = findViewById(R.id.st2_btn_clear);
        st2_drawlinear = findViewById(R.id.st2_draw_linear);
        st2_clearbtn.setOnClickListener(new View.OnClickListener() { //지우기 버튼 눌렸을때
            @Override
            public void onClick(View v){
                points.clear();
                m.invalidate();
            }
        });
        st2_drawlinear.addView(m);

        st2_btn_submit = findViewById(R.id.st2_btn_submit);
        st2_btn_submit.setOnClickListener(new View.OnClickListener() { //제출 버튼 눌렀을 때
            @Override
            public void onClick(View v){
                Toast.makeText(st2_paint.this, "제출이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(st2_paint.this, st2_Sub1Activity.class);
                startActivity(intent); //액티비티 이동
                Toast.makeText(st2_paint.this, "힌트를 획득하여 힌트창을 확인하세요.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}