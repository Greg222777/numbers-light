package com.nowik.numberslight.model;

import com.google.gson.annotations.SerializedName;

public class Number {

    @SerializedName("name")
    public String id;
    @SerializedName("image")
    public String iconUrl;

    @Override
    public String toString() {
        return "Number{" +
                "id='" + id + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Number(String id, String iconUrl) {
        this.id = id;
        this.iconUrl = iconUrl;
    }
}
