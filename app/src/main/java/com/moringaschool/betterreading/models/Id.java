package com.moringaschool.betterreading.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id {
    @SerializedName("-type")
    @Expose
    private String type;
    @SerializedName("#text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     *
     */
    public Id() {
    }

    /**
     *
     * @param text
     * @param type
     */
    public Id(String type, String text) {
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
