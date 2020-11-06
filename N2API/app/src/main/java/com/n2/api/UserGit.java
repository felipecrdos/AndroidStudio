package com.n2.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UserGit {
    public User getInformacao(String end){
        String json = Connection.getJsonFromApi(end);
        User newUser = parseJson(json);
        return newUser;
    }

    private User parseJson(String json){

        try {
            User user = new User();
//            JSONObject jsonObj = new JSONObject(json);
//            JSONArray array = jsonObj.getJSONArray("characters");
//            JSONObject obj = array.getJSONObject(new Random().nextInt(array.length()));
            System.out.println("===========================================\n------------------------------------------------");
            JSONObject obj = new JSONObject(json);

            //Name and role
            String name = obj.getString("name");
            System.out.println("=========================////==================" + name);
            user.setName(name);
//            String role = obj.getString("role");
//            user.setRole(role);

            // id
            Integer id = obj.getInt("id");
            user.setId(id);

            //Avatar
            String avatar = obj.getString("avatar_url");
            user.setAvatar(baixarImagem(avatar));
//
//            //Actor
//            JSONArray actorArray = obj.getJSONArray("voice_actors");
//            JSONObject actorObj = actorArray.getJSONObject(0);
//            Actor actor = new Actor();
//            actor.setName(actorObj.getString("name"));
//            actor.setLanguage(actorObj.getString("language"));
//            String actorAvatar = actorObj.getString("image_url");
//            actor.setAvatar(baixarImagem(actorAvatar));
//            user.setActor(actor);

            return user;
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
