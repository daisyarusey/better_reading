package com.moringaschool.betterreading.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Books {
    @SerializedName("GoodreadsResponse")
    @Expose
    private GoodReadsResponse goodreadsResponse;

    /**
     * No args constructor for use in serialization
     *
     */
    public Books() {
    }

    /**
     *
     * @param goodreadsResponse
     */
    public Books(GoodReadsResponse goodreadsResponse) {
        super();
        this.goodreadsResponse = goodreadsResponse;
    }

    public GoodReadsResponse getGoodreadsResponse() {
        return goodreadsResponse;
    }

    public void setGoodreadsResponse(GoodReadsResponse goodreadsResponse) {
        this.goodreadsResponse = goodreadsResponse;
    }
}
