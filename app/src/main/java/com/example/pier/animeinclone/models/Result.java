package com.example.pier.animeinclone.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    private final static long serialVersionUID = -6412563747900382567L;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}