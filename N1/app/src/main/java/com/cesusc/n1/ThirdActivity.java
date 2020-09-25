package com.cesusc.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView nameLable = findViewById(R.id.name);
        TextView mediaLable = findViewById(R.id.media);
        TextView resultadoLable = findViewById(R.id.resultado);

        nameLable.setText(getIntent().getStringExtra("name"));
        String mediaText = String.format("%.2f", getIntent().getDoubleExtra("media", 0));
        mediaLable.setText(mediaText);

        String result = Double.parseDouble(mediaText) >= 7.0 ? "APROVADO" : "REPROVADO";
        resultadoLable.setText(result);



    }
}