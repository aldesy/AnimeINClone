package com.example.pier.animeinclone.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.example.pier.animeinclone.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.videoView)
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String streamlink = b.getString("streamlink");
        Uri vidUri = Uri.parse(streamlink);
        videoView.setVideoURI(vidUri);
        videoView.start();
    }
}
