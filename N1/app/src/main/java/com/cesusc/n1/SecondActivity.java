package com.cesusc.n1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button back = findViewById(R.id.calcular);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( SecondActivity.this, ThirdActivity.class );

                EditText nota01 = findViewById(R.id.nota01);
                EditText nota02 = findViewById(R.id.nota02);

                String v1 = nota01.getText().toString();
                String v2 = nota02.getText().toString();


                Double n1 = Double.parseDouble(v1);
                Double n2 = Double.parseDouble(v2);

                TextView errorMsg = findViewById(R.id.erro);
                if(n1 > 10.0 || n2 > 10.0) {
                    errorMsg.setVisibility(View.VISIBLE);
                    return;
                }
                errorMsg.setVisibility(View.INVISIBLE);
                Double media = (n1+n2)/2.0;

                String name = getIntent().getStringExtra("name");
                intent.putExtra("name", name);
                intent.putExtra("media", media);
                startActivity(intent);
            }
        });
    }
}