package com.example.pier.animeinclone.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episode {

    @SerializedName("episodeid")
    @Expose
    private String episodeid;
    @SerializedName("episodenumber")
    @Expose
    private String episodenumber;
    @SerializedName("view")
    @Expose
    private String view;
    @SerializedName("anime")
    @Expose
    private String anime;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("streamlink")
    @Expose
    private String streamlink;

    public int getEpisodeid() {
        return Integer.parseInt(episodeid);
    }

    public void setEpisodeid(String episodeid) {
        this.episodeid = episodeid;
    }

    public String getEpisodenumber() {
        return episodenumber;
    }

    public void setEpisodenumber(String episodenumber) {
        this.episodenumber = episodenumber;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getStreamlink() {
        return streamlink;
    }

    public void setStreamlink(String streamlink) {
        this.streamlink = streamlink;
    }
}