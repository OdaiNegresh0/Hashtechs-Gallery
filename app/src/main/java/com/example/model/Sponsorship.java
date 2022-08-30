package com.example.model;

import com.example.model.Sponsor;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Sponsorship implements Serializable {
    @SerializedName("impression_urls")
    private ArrayList<String> impression_urls;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("tagline_url")
    private String tagline_url;
    @SerializedName("sponsor")
    private Sponsor sponsor;

    public ArrayList<String> getImpression_urls() {
        return impression_urls;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTagline_url() {
        return tagline_url;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }
}