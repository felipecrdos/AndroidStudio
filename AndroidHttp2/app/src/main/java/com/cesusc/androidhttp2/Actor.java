package com.cesusc.androidhttp2;

import android.graphics.Bitmap;
public class Actor {
    private String name;
    private String language;
    private Bitmap avatar;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public Bitmap getAvatar() {
        return avatar;
    }
    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }
}
