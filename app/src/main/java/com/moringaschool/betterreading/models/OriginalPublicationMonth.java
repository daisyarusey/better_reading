package com.moringaschool.betterreading.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginalPublicationMonth {
    @SerializedName("-type")
    @Expose
    private String type;
    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("-nil")
    @Expose
    private String nil;

    /**
     * No args constructor for use in serialization
     *
     */
    public OriginalPublicationMonth() {
    }

    /**
     *
     * @param text
     * @param type
     * @param nil
     */
    public OriginalPublicationMonth(String type, String text, String nil) {
        super();
        this.type = type;
        this.text = text;
        this.nil = nil;
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

    public String getNil() {
        return nil;
    }

    public void setNil(String nil) {
        this.nil = nil;
    }


}
