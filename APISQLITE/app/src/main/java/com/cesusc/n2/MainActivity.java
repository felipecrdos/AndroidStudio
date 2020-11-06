package com.cesusc.n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.deleteDatabase("banco.db");
    }

    public void goToRegister(View view){
        Intent intent = new Intent( MainActivity.this, RegisterActivity.class );
        startActivity(intent);
    }

    public void goToList(View view){
        Intent intent = new Intent( MainActivity.this, ListActivity.class );
        startActivity(intent);
    }
}