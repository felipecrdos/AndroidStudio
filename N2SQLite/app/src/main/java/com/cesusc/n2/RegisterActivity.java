package com.cesusc.n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText phone;
    TextView error;
    ModelDAO dao;
    private final String URL = "https://asterinfo.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.nome);
        phone = findViewById(R.id.phone);
        error = findViewById(R.id.errorPopup);
        dao = new ModelDAO(this);
    }

    public void salvar(View view){
        if(!emptyFields()){
            error.setVisibility(error.INVISIBLE);
            Model model = new Model();
            model.setName(name.getText().toString());
            model.setPhone(phone.getText().toString());
            long id = dao.insert(model);
            Toast.makeText(this, "Add model id: " + id, Toast.LENGTH_SHORT).show();
            cleanFields();
        }else{
            error.setVisibility(error.VISIBLE);
        }
    }

    public void back(View view){
        Intent intent = new Intent( RegisterActivity.this, MainActivity.class );
        startActivity(intent);
    }

    private void cleanFields(){
        name.setText("");
        phone.setText("");
    }

    private boolean emptyFields(){
       if(name.getText().toString().equals("") || phone.getText().toString().equals(""))
           return true;
        return false;
    }
}