package com.example.model;

import com.example.model.Links;
import com.example.model.ProfileImage;
import com.example.model.Social;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Sponsor implements Serializable {
    @SerializedName("id")
    private String id;
    @SerializedName("updated_at")
    private Date updated_at;
    @SerializedName("username")
    private String username;
    @SerializedName("name")
    private String name;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("bio")
    private String bio;
    @SerializedName("links")
    private Links links;
    @SerializedName("profile_image")
    private ProfileImage profile_image;
    @SerializedName("instagram_username")
    private String instagram_username;
    @SerializedName("total_collections")
    private int total_collections;
    @SerializedName("total_likes")
    private int total_likes;
    @SerializedName("total_photos")
    private int total_photos;
    @SerializedName("accepted_tos")
    private boolean accepted_tos;
    @SerializedName("for_hire")
    private boolean for_hire;
    @SerializedName("social")
    private Social social;

    public String getId() {
        return id;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getBio() {
        return bio;
    }

    public Links getLinks() {
        return links;
    }

    public ProfileImage getProfile_image() {
        return profile_image;
    }

    public String getInstagram_username() {
        return instagram_username;
    }

    public int getTotal_collections() {
        return total_collections;
    }

    public int getTotal_likes() {
        return total_likes;
    }

    public int getTotal_photos() {
        return total_photos;
    }

    public boolean isAccepted_tos() {
        return accepted_tos;
    }

    public boolean isFor_hire() {
        return for_hire;
    }

    public Social getSocial() {
        return social;
    }
}