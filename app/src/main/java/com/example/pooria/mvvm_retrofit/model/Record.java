
package com.example.pooria.mvvm_retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {

    @SerializedName("publisher")
    @Expose
    public String publisher;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("imageurl")
    @Expose
    public String imageurl;
    @SerializedName("createdby")
    @Expose
    public String createdby;
    @SerializedName("team")
    @Expose
    public String team;
    @SerializedName("firstappearance")
    @Expose
    public Integer firstappearance;
    @SerializedName("realname")
    @Expose
    public String realname;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(Integer firstappearance) {
        this.firstappearance = firstappearance;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }


    public Record(String publisher, String name, String bio, String imageurl, String createdby, String team, Integer firstappearance, String realname) {

        this.publisher = publisher;
        this.name = name;
        this.bio = bio;
        this.imageurl = imageurl;
        this.createdby = createdby;
        this.team = team;
        this.firstappearance = firstappearance;
        this.realname = realname;
    }

    public Record() {

    }
}
