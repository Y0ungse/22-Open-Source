package com.example.room;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class st5_MusicService extends Service {
    MediaPlayer st5_mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        st5_mediaPlayer = MediaPlayer.create(this, R.raw.st5_bgm); //bgm 재생
        st5_mediaPlayer.setLooping(true); //무한 반복
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        st5_mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        st5_mediaPlayer.stop(); //bgm 종료
        st5_mediaPlayer.release();
        super.onDestroy();
    }

}