package com.example.pier.animeinclone.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopAnimeResult {

    @SerializedName("mal_id")
    @Expose
    private Integer mal_id;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_url")
    @Expose
    private String image_url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("score")
    @Expose
    private float score;
    @SerializedName("members")
    @Expose
    private Integer members;
    @SerializedName("airing_start")
    @Expose
    private String airing_start;
    @SerializedName("airing_end")
    @Expose
    private Object airing_end;
    @SerializedName("episodes")
    @Expose
    private Integer episodes;

    public Integer getMal_id() {
        return mal_id;
    }

    public void setMal_id(Integer mal_id) {
        this.mal_id = mal_id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public String getAiring_start() {
        return airing_start;
    }

    public void setAiring_start(String airing_start) {
        this.airing_start = airing_start;
    }

    public Object getAiring_end() {
        return airing_end;
    }

    public void setAiring_end(Object airing_end) {
        this.airing_end = airing_end;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

}