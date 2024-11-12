package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity_Video extends YouTubeBaseActivity {

    //객체 선언
    YouTubePlayerView playerView;
    YouTubePlayer player;

    //유튜브 API KEY와 동영상 Id 변수 설정
    private static String API_KEY = "AIzaSyBZ-B5eHbaVogC0TeqRDD2ozZwi9-GsJoU";
    private static String videoId ="alxcwyMJ58E";

    //Logcat 사용 설정
    private static final String TAG ="MainActivity_Video";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_video);

        initPlayer();

        Button btnPlay = findViewById(R.id.youtubeBtn);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }

    private void playVideo() {
        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
            }
            player.cueVideo(videoId);//동영상 재생
        }
    }

    //유뷰트 플레이어 메서드
    private void initPlayer() {
        playerView = findViewById(R.id.youTubePlayerView);
        //YouTubePlayerView 초기화하기
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;

                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onLoaded(String s) {
                        Log.d(TAG, "onLoaded: " + s);
                        player.play();//동영상이 로딩되었으면 재생하기

                    }

                    @Override
                    public void onAdStarted() {

                    }

                    @Override
                    public void onVideoStarted() {

                    }

                    @Override
                    public void onVideoEnded() {
                        Intent intent = new Intent(MainActivity_Video.this, MainActivity.class);
                        //영상이 끝났다면 액티비티 종료
                        startActivity(intent);
                    }

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {
                        Log.d(TAG, "onError: " + errorReason);
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }

        });
    }
}