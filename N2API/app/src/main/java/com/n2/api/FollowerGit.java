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
            JSONArray array = new JSONArray(json);
            JSONObject obj = array.getJSONObject(new Random().nextInt(array.length()));

            //Name and role
            String name = obj.getString("login");
            follower.setLogin(name);

            // id
            Integer id = obj.getInt("id");
            follower.setId(id);
            //Avatar
            String avatar = obj.getString("avatar_url");
            follower.setAvatar(baixarImagem(avatar));

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
