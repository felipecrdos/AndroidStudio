package com.udemy.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Button button = findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( SecondActivity.this, MainActivity.class );
                EditText lastname = findViewById(R.id.lastname);
                String lastnameValue = lastname.getText().toString();
                intent.putExtra("lastname", lastnameValue);
                startActivity(intent);
            }
        });
    }
}