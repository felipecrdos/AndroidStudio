package com.cesusc.n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ModelDAO dao;
    ListView linear;
    List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        dao = new ModelDAO(this);
        linear = findViewById(R.id.listView);
        models = new ArrayList<Model>();
        models = dao.findAll();

        ArrayAdapter<Model> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, models);
        linear.setAdapter(adapter);
    }
    public void back(View view){
        Intent intent = new Intent( ListActivity.this, MainActivity.class );
        startActivity(intent);
    }
}