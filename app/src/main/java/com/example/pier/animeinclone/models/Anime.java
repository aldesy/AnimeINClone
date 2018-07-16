package com.example.pier.animeinclone.models;

public class Anime {



    private String imagelink, genre, title;
    private int views;

    public Anime(){}

    public Anime(String imagelink) {
        this.imagelink = imagelink;
    }

    public Anime(String imagelink, String genre, String title, int views) {
        this.imagelink = imagelink;
        this.genre = genre;
        this.title = title;
        this.views = views;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
