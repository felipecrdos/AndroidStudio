package com.n2.api;

import android.graphics.Bitmap;

public class User {

    private Integer id;
    private String name;
    private Bitmap avatar;

    public Bitmap getAvatar() {
        return avatar;
    }
    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
