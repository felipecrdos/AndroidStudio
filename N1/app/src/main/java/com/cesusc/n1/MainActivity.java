package com.cesusc.n1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import  android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, SecondActivity.class );
                EditText name = findViewById(R.id.name);
                String nameValue = name.getText().toString();
                intent.putExtra("name", nameValue);
                startActivity(intent);
            }
        });
    }
}