package com.example.pier.animeinclone.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MALTopAnimeResponse {

    @SerializedName("request_hash")
    @Expose
    private String request_hash;
    @SerializedName("request_cached")
    @Expose
    private Boolean request_cached;
    @SerializedName("top")
    @Expose
    private List<TopAnimeResult> top = null;

    public String getRequest_hash() {
        return request_hash;
    }

    public void setRequest_hash(String request_hash) {
        this.request_hash = request_hash;
    }

    public Boolean getRequest_cached() {
        return request_cached;
    }

    public void setRequest_cached(Boolean request_cached) {
        this.request_cached = request_cached;
    }

    public List<TopAnimeResult> getTop() {
        return top;
    }

    public void setTop(List<TopAnimeResult> top) {
        this.top = top;
    }

}