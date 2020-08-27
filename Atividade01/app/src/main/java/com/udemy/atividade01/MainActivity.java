package com.udemy.atividade01;

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
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.nextButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, SecondActivity.class );
                EditText name = findViewById(R.id.name);
                String nameValue = name.getText().toString();
                intent.putExtra("name", nameValue);
                startActivity(intent);
            }
        });
    }
}