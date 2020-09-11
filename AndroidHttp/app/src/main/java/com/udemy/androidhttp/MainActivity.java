package com.udemy.androidhttp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nome;
    private TextView sobrenome;
    private TextView email;
    private TextView cidade;
    private TextView estado;
    private ImageView avatar;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPessoa download = new DownloadPessoa();

        nome = (TextView)findViewById(R.id.nome);
        sobrenome = (TextView)findViewById(R.id.sobrenome);
        email = (TextView)findViewById(R.id.email);
        cidade = (TextView)findViewById(R.id.cidade);
        estado = (TextView)findViewById(R.id.estado);
        avatar = (ImageView) findViewById(R.id.avatar);

        download.execute();
    }

    private class DownloadPessoa extends AsyncTask<Void, Void, Pessoa>{

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde...", "Obtendo informações");
        }

        @Override
        protected Pessoa doInBackground(Void... params) {
            Conversor util = new Conversor();
            return util.getInformacao("https://randomuser.me/api/0.7");
        }

        @Override
        protected void onPostExecute(Pessoa pessoa) {
            nome.setText(pessoa.getNome());
            sobrenome.setText(pessoa.getSobrenome());
            email.setText(pessoa.getEmail());
            cidade.setText(pessoa.getCidade());
            estado.setText(pessoa.getEstado());
            avatar.setImageBitmap(pessoa.getAvatar());

            load.dismiss(); // deletar dialogo
        }
    }
}