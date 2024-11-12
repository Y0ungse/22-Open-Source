package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class st4_piano extends AppCompatActivity {
    SoundPool pool;
    int st4_d1, st4_re, st4_mi, st4_pa, st4_sol, st4_ra, st4_si, st4_d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Window win=getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.st4_piano);

        pool=new SoundPool(4, AudioManager.STREAM_MUSIC,0);
        st4_d1 = pool.load(this,R.raw.st4_d1,1);
        st4_d2 = pool.load(this,R.raw.st4_d2,1);
        st4_re = pool.load(this,R.raw.st4_re,1);
        st4_mi = pool.load(this,R.raw.st4_mi,1);
        st4_pa = pool.load(this,R.raw.st4_pa,1);
        st4_sol = pool.load(this,R.raw.st4_sol,1);
        st4_ra = pool.load(this,R.raw.st4_ra,1);
        st4_si = pool.load(this,R.raw.st4_si,1);
    }
    public void mOnClick(View v){

        switch(v.getId())
        {
            case R.id.st4_do1:
                pool.play(st4_d1,1,1,0,0,1);
                break;
            case R.id.st4_do2:
                pool.play(st4_d2,1,1,0,0,1);
                break;
            case R.id.st4_si:
                pool.play(st4_si,1,1,0,0,1);
                break;
            case R.id.st4_ra:
                pool.play(st4_ra,1,1,0,0,1);
                break;
            case R.id.st4_sol:
                pool.play(st4_sol,1,1,0,0,1);
                break;
            case R.id.st4_pa:
                pool.play(st4_pa,1,1,0,0,1);
                break;
            case R.id.st4_mi:
                pool.play(st4_mi,1,1,0,0,1);
                break;
            case R.id.st4_re1:
                pool.play(st4_re,1,1,0,0,1);
                break;
            case R.id.button30:
                pool.play(st4_re,1,1,0,0,1);
                break;
            case R.id.button32:
                pool.play(st4_d2,1,1,0,0,1);
                break;
            case R.id.button34:
                pool.play(st4_si,1,1,0,0,1);
                break;
            case R.id.button35:
                pool.play(st4_ra,1,1,0,0,1);
                break;
            case R.id.button36:
                pool.play(st4_pa,1,1,0,0,1);
                break;
            case R.id.button37:
                pool.play(st4_mi,1,1,0,0,1);
                break;
        }
    }
}