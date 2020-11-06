package com.n2.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class FollowerGit {
    public Follower getInformacao(String end){
        String json = Connection.getJsonFromApi(end);
        Follower newFollower = parseJson(json);
        return newFollower;
    }

    private Follower parseJson(String json){

        try {
            Follower follower = new Follower();
            //JSONObject jsonObj = new JSONObject(json);
            //JSONArray array = jsonObj.getJSONArray(null);
            JSONArray array = new JSONArray(json);
            System.out.println("==============================" + array);
            //JSONObject obj = array.getJSONObject(new Random().nextInt(array.length()));
            JSONObject obj = array.getJSONObject(1);
            System.out.println("-----------------------------------" + obj);

            //Name and role
            String name = obj.getString("login");
            System.out.println("-----------------------------------" + name);
            follower.setLogin(name);
//            String role = obj.getString("role");
//            Follower.setRole(role);

            // id
            Integer id = obj.getInt("id");
            follower.setId(id);
            System.out.println("----------------------------------- id: " + id);

            //Avatar
            String avatar = obj.getString("avatar_url");
            System.out.println("----------------------------------- avatar: " + avatar);
            follower.setAvatar(baixarImagem(avatar));
//
//            //Actor
//            JSONArray actorArray = obj.getJSONArray("voice_actors");
//            JSONObject actorObj = actorArray.getJSONObject(0);
//            Actor actor = new Actor();
//            actor.setName(actorObj.getString("name"));
//            actor.setLanguage(actorObj.getString("language"));
//            String actorAvatar = actorObj.getString("image_url");
//            actor.setAvatar(baixarImagem(actorAvatar));
//            Follower.setActor(actor);

            return follower;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    private Bitmap baixarImagem(String url) {
        try {
            URL endereco = new URL(url);
            InputStream inputStream = endereco.openStream();
            Bitmap image = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
