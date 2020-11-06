package com.n2.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
            JSONObject obj = new JSONObject(json);

            //Name and role
            String name = obj.getString("name");
            user.setName(name);

            // id
            Integer id = obj.getInt("id");
            user.setId(id);

            //Avatar
            String avatar = obj.getString("avatar_url");
            user.setAvatar(baixarImagem(avatar));

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
