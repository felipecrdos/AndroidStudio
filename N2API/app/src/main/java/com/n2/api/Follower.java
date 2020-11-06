package com.n2.api;

import android.graphics.Bitmap;

public class Follower {

    private Integer id;
    private String login;
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
}
