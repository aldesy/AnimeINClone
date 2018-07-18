package com.example.pier.animeinclone.models;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Serializable
{

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
    @SerializedName("view")
    @Expose
    private String view;
    private final static long serialVersionUID = 8719160951506879544L;

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

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

}