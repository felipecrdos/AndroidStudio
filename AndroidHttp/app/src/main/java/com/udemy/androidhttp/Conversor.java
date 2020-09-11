package com.udemy.androidhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversor {

    public Pessoa getInformacao(String end){
        String json = ConexaoApi.getJsonFromApi(end);
        Pessoa newPessoa = parseJson(json);
        return newPessoa;
    }

    private Pessoa parseJson(String json){

        try {
            Pessoa pessoa = new Pessoa();
            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("results");

            JSONObject objArray = array.getJSONObject(0);
            JSONObject obj = objArray.getJSONObject("user");

            //Nome e Sobrenome
            JSONObject nameObj = obj.getJSONObject("name");
            pessoa.setNome(nameObj.getString("first"));
            pessoa.setSobrenome(nameObj.getString("last"));

            //Email
            pessoa.setEmail(obj.getString("email"));

            //Endereco
            JSONObject endereco = obj.getJSONObject("location");
            pessoa.setEstado(endereco.getString("state"));
            pessoa.setCidade(endereco.getString("city"));

            //Avatar
            JSONObject avatarObj = obj.getJSONObject("picture");
            pessoa.setAvatar(baixarImagem(avatarObj.getString("large")));

            return pessoa;
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
