package com.cesusc.androidhttp2;

import android.graphics.BitmapFactory;

import java.io.IOException;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class Conversor {

        public Personagem getInformacao(String end){
            String json = ConexaoApi.getJsonFromApi(end);
            Personagem newPersonagem = parseJson(json);
            return newPersonagem;
        }

        private Personagem parseJson(String json){

            try {
                Personagem personagem = new Personagem();
                JSONObject jsonObj = new JSONObject(json);
                JSONArray array = jsonObj.getJSONArray("characters");
                JSONObject obj = array.getJSONObject(new Random().nextInt(array.length()));

                //Name and role
                String name = obj.getString("name");
                personagem.setName(name);
                String role = obj.getString("role");
                personagem.setRole(role);

                //Avatar
                String avatar = obj.getString("image_url");
                personagem.setAvatar(baixarImagem(avatar));

                //Actor
                JSONArray actorArray = obj.getJSONArray("voice_actors");
                JSONObject actorObj = actorArray.getJSONObject(0);
                Actor actor = new Actor();
                actor.setName(actorObj.getString("name"));
                actor.setLanguage(actorObj.getString("language"));
                String actorAvatar = actorObj.getString("image_url");
                actor.setAvatar(baixarImagem(actorAvatar));

                personagem.setActor(actor);
                return personagem;
            }catch (JSONException e){
                e.printStackTrace();
            }
            return null;
        }

        private Bitmap baixarImagem(String url) {
            try {
                URL endereco = new URL(url);
                InputStream inputStream = endereco.openStream();
                Bitmap imagem = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return imagem;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
}
