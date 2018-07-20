package com.example.pier.animeinclone;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

import com.example.pier.animeinclone.interfaces.IMediaController;


public class FullScreenMediaController extends MediaController{

    private ImageButton fullScreen;
    private boolean isFullScreen;
    private IMediaController callback;

    public FullScreenMediaController(Context context) {
        super(context);
    }
    public FullScreenMediaController(Context context, IMediaController callback) {
        super(context);
        this.callback = callback;
        this.isFullScreen = false;
    }

    @Override
    public void setAnchorView(View view) {

        super.setAnchorView(view);

        //image button for full screen to be added to media controller
        fullScreen = new ImageButton (super.getContext());

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
        params.rightMargin = 80;
        addView(fullScreen, params);

        if(isFullScreen){
            fullScreen.setImageResource(R.drawable.ic_search_black_24dp);
        }else{
            fullScreen.setImageResource(R.drawable.ic_search_black_24dp);
        }

        //add listener to image button to handle full screen and exit full screen events
        fullScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isFullScreen = !isFullScreen;
                callback.OnClickFullScreen(isFullScreen);
            }
        });
    }
}