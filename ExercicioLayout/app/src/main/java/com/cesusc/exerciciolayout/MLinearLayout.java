package com.cesusc.exerciciolayout;

import android.os.Bundle;
import  android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MLinearLayout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        final Button button = findViewById(R.id.nextButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( MLinearLayout.this, MFrameLayout.class );
                //EditText name = findViewById(R.id.name);
                //String nameValue = name.getText().toString();
                //intent.putExtra("name", nameValue);
                startActivity(intent);
            }
        });
    }
}
