package com.cesusc.n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText diameter;
    EditText distance;
    EditText finder;
    TextView title;
    ModelDAO dao;
    private Resource Resource;
    private final String URL = "https://asterinfo.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.nome);
        diameter = findViewById(R.id.diametro);
        distance = findViewById(R.id.distancia);
        finder = findViewById(R.id.descobridor);
        title = findViewById(R.id.title);
        dao = new ModelDAO(this);

        // salvar recursos vindo da api
        // saveResources();

        // salvar recurso(id) vindo da api
        //saveByIdResources(1);

        // deletar por id
        //dao.deleteById(1);

        // deletar todos
        //dao.deleteAll();
    }

    public void salvar(View view){
        if(!emptyFields()){
            Model model = new Model();
            model.setName(name.getText().toString());
            model.setDiameter(Integer.parseInt(diameter.getText().toString()));
            model.setDistance(distance.getText().toString());
            model.setFinder(finder.getText().toString());
            long id = dao.insert(model);
            Toast.makeText(this, "Add model id: " + id, Toast.LENGTH_SHORT).show();
            cleanFields();
        }
    }

    public void back(View view){
        Intent intent = new Intent( RegisterActivity.this, MainActivity.class );
        startActivity(intent);
    }

    private void cleanFields(){
        name.setText("");
        diameter.setText("");
        distance.setText("");
        finder.setText("");
    }

    private boolean emptyFields(){
       if(      name.getText().toString().equals("") || diameter.getText().toString().equals("") ||
                distance.getText().toString().equals("") || finder.getText().toString().equals(""))
           return true;
        return false;
    }

    private void saveResources(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ModelRoute service = retrofit.create(ModelRoute.class);
        Call<Resource> resource = service.getResouces();
        resource.enqueue(new Callback<Resource>(){
            @Override
            public void onResponse(Call<Resource> call, Response<Resource> response) {
                if(!response.isSuccessful()){
                    Log.i("TAG", "Erro: " + response.code());
                    System.out.println(response.code());
                }else{
                    Resource resouces = response.body();
                    for(Model model : resouces.models) {
                        dao.insert(model);
                    }
                }
            }
            @Override
            public void onFailure(Call<Resource> call, Throwable t) {
                Log.e("TAG", "Erro: " + t.getMessage());
            }
        });
    }

    private void saveByIdResources(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ModelRoute service = retrofit.create(ModelRoute.class);
        Call<Resource> resource = service.getResouceById(id);
        resource.enqueue(new Callback<Resource>(){
            @Override
            public void onResponse(Call<Resource> call, Response<Resource> response) {
                if(!response.isSuccessful()){
                    Log.i("TAG", "Erro: " + response.code());
                }else{
                    Resource resouces = response.body();
                    for(Model model : resouces.models) {
                        dao.insert(model);
                    }
                    //System.out.println(resouces.models.get(0).toString());
                }
            }
            @Override
            public void onFailure(Call<Resource> call, Throwable t) {
                Log.e("TAG", "Erro: " + t.getMessage());
            }
        });
    }
}