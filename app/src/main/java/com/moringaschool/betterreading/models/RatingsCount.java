package com.moringaschool.betterreading.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingsCount {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("content")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     *
     */
    public RatingsCount() {
    }

    /**
     *
     * @param text
     * @param type
     */
    public RatingsCount(String type, String text) {
        super();
        this.type = type;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
