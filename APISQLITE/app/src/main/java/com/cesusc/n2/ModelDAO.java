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

    public long insert(Model modelo){ // retorn o id
        ContentValues values = new ContentValues();
        values.put("name", modelo.getName());
        values.put("diameter", modelo.getDiameter());
        values.put("distance", modelo.getDistance());
        values.put("finder", modelo.getFinder());
        return banco.insert("model", null, values);
    }

    public List<Model> findAll(){
        List<Model> models = new ArrayList<>();
        Cursor cursor = banco.query("model", new String[]{"id","name","diameter","distance","finder"},
                null, null, null, null, null);

        while (cursor.moveToNext()){
            Model model = new Model();
            model.setId(cursor.getInt(0));
            model.setName(cursor.getString(1));
            model.setDiameter(cursor.getInt(2));
            model.setDistance(cursor.getString(3));
            model.setFinder(cursor.getString(4));
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
