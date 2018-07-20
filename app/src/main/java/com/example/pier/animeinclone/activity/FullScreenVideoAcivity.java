package com.example.pier.animeinclone.activity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pier.animeinclone.R;
import com.universalvideoview.UniversalMediaController;
import com.universalvideoview.UniversalVideoView;

public class FullScreenVideoAcivity extends AppCompatActivity {

    UniversalVideoView mVideoView;
    public int stopPosition;
    public View mVideoLayout;
    public UniversalMediaController mMediaController;
    public boolean checkFullScreen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_video);

        String streamlink =  getIntent().getStringExtra("streamlink");
//
//        final View mBottomLayout;
        mVideoLayout = findViewById(R.id.video_layout);
    //    final View mBottomLayout = findViewById(R.id.bottom_layout);

        mVideoView = findViewById(R.id.videoView);
        TextView loading_text;
        loading_text = findViewById(R.id.loading_text);
        loading_text.setText("Mohon Tunggu...");

        mMediaController = findViewById(R.id.media_controller);
        mVideoView.setMediaController(mMediaController);

        Uri vidUri = Uri.parse(streamlink);
        mVideoView.setVideoURI(vidUri);

        mVideoView.setVideoViewCallback(new UniversalVideoView.VideoViewCallback() {

            @Override
            public void onScaleChange(boolean isFullscreen) {
                if (isFullscreen) {
                    checkFullScreen = true;
                    ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    mVideoLayout.setLayoutParams(layoutParams);
                    //GONE the unconcerned views to leave room for video and controller
                   // mBottomLayout.setVisibility(View.GONE);
                } else {
                    checkFullScreen = false;
                    ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
                    layoutParams.height = height;
                    mVideoLayout.setLayoutParams(layoutParams);
                    //mBottomLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPause(MediaPlayer mediaPlayer) { // Video pause
              //  Log.d(TAG, "onPause UniversalVideoView callback");
            }

            @Override
            public void onStart(MediaPlayer mediaPlayer) { // Video start/resume to play
              //  Log.d(TAG, "onStart UniversalVideoView callback");
            }

            @Override
            public void onBufferingStart(MediaPlayer mediaPlayer) {// steam start loading
            //    Log.d(TAG, "onBufferingStart UniversalVideoView callback");
            }

            @Override
            public void onBufferingEnd(MediaPlayer mediaPlayer) {// steam end loadin
            //    Log.d(TAG, "onBufferingEnd UniversalVideoView callback");
            }

        });

        mVideoView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopPosition = mVideoView.getCurrentPosition(); //stopPosition is an int
        mVideoView.pause();
    }
    @Override
    public void onResume() {
        super.onResume();
        mVideoView.seekTo(stopPosition);
        mVideoView.start(); //Or use resume() if it doesn't work. I'm not sure
    }

    @Override
    public void onBackPressed()
    {
        if(checkFullScreen)
        {
            mVideoView.setFullscreen(false);
        }
        else super.onBackPressed();

    }
}
