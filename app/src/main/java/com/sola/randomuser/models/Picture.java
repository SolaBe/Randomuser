package com.sola.randomuser.models;

import java.io.Serializable;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class Picture implements Serializable{

    private String large;

    private String medium;

    private String thumbnail;


    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
