package com.example.pier.animeinclone.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animes {

    @SerializedName("animeid")
    @Expose
    private String animeid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("sinopsis")
    @Expose
    private String sinopsis;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("imgbackground")
    @Expose
    private String imgbackground;
    @SerializedName("view")
    @Expose
    private String view;
    @SerializedName("episodes")
    @Expose
    private List<Episode> episodes = null;

    public String getAnimeid() {
        return animeid;
    }

    public void setAnimeid(String animeid) {
        this.animeid = animeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImgbackground() {
        return imgbackground;
    }

    public void setImgbackground(String imgbackground) {
        this.imgbackground = imgbackground;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

}