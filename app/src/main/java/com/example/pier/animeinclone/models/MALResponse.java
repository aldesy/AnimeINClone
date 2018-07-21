package com.example.pier.animeinclone.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MALResponse {

    @SerializedName("request_hash")
    @Expose
    private String request_hash;
    @SerializedName("request_cached")
    @Expose
    private Boolean request_cached;
    @SerializedName("result")
    @Expose
    private List<MALResult> result = null;
    @SerializedName("result_last_page")
    @Expose
    private Integer result_last_page;

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

    public List<MALResult> getResult() {
        return result;
    }

    public void setResult(List<MALResult> result) {
        this.result = result;
    }

    public Integer getResult_last_page() {
        return result_last_page;
    }

    public void setResult_last_page(Integer result_last_page) {
        this.result_last_page = result_last_page;
    }

}