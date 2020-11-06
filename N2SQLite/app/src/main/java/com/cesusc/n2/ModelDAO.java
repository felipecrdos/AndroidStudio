package com.cesusc.n2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ModelDAO {

    private Connection connection;
    private SQLiteDatabase banco;

    public ModelDAO(Context context){
        connection = new Connection(context);
        banco = connection.getWritableDatabase();
    }

    public long insert(Model modelo){ // return o id
        ContentValues values = new ContentValues();
        values.put("name", modelo.getName());
        values.put("phone", modelo.getPhone());
        return banco.insert("model", null, values);
    }

    public List<Model> findAll(){
        List<Model> models = new ArrayList<>();
        Cursor cursor = banco.query("model", new String[]{"id","name","phone"},
                null, null, null, null, null);

        while (cursor.moveToNext()){
            Model model = new Model();
            model.setId(cursor.getInt(0));
            model.setName(cursor.getString(1));
            model.setPhone(cursor.getString(2));
            models.add(model);
        }
        return models;
    }
    public void deleteById(int id){
        try{
            banco.delete("model", String.format("id = %d", id),null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteAll(){
        try{
            banco.delete("model", null, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
