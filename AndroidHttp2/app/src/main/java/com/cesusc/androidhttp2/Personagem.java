package com.cesusc.androidhttp2;
import android.graphics.Bitmap;

public class Personagem {
    private String name;
    private String role;
    private Bitmap avatar;
    private Actor actor;

    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public Bitmap getAvatar() {
        return avatar;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }
    public Actor getActor() {
        return actor;
    }
    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
