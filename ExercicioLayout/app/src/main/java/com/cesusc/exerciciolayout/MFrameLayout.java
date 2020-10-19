package com.cesusc.exerciciolayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MFrameLayout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        final Button button = findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( MFrameLayout.this, MLinearLayout.class );
                //EditText name = findViewById(R.id.name);
                //String nameValue = name.getText().toString();
                //intent.putExtra("name", nameValue);
                startActivity(intent);
            }
        });
    }
}
