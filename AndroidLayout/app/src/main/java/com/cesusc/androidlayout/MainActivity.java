package com.cesusc.androidlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import  android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
    }

    public void onClickNext(){
        Intent intent = new Intent( MainActivity.this, MainActivity.class );
        //EditText name = findViewById(R.id.name);
        //String nameValue = name.getText().toString();
        //intent.putExtra("name", nameValue);
        startActivity(intent);
    }
}