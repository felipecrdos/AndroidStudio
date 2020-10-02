package com.cesusc.androidhttp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView role;
    private ImageView avatar;
    private ProgressDialog load;

    private TextView actorName;
    private TextView actorLanguage;
    private ImageView actorAvatar;

    private long lastClick = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DownloadPersonagem download = new DownloadPersonagem();
        name = (TextView)findViewById(R.id.name);
        role = (TextView)findViewById(R.id.role);
        avatar = (ImageView) findViewById(R.id.avatar);

        final List<String> colors = Arrays.asList("#726a95", "#709fb0", "#a0c1b8",
                                            "#7579e7", "#835858", "#463333",
                                            "#0f3057", "#0278ae", "#51adcf",
                                            "#ccf6c8", "#efbbcf");
        final ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor(colors.get(new Random().nextInt(colors.size()))));
        Button update = (Button)findViewById(R.id.update);

        actorName = (TextView)findViewById(R.id.actorName);
        actorLanguage = (TextView)findViewById(R.id.actorLanguage);
        actorAvatar = (ImageView) findViewById(R.id.actorAvatar);

        download.execute();


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SystemClock.elapsedRealtime() - lastClick < 300)
                    return;
                lastClick = SystemClock.elapsedRealtime();
                updateLayout(colors, layout, download);
            }
        });
    }

    public void updateLayout(List<String> colors, ConstraintLayout l, DownloadPersonagem d){
        l.setBackgroundColor(Color.parseColor(colors.get(new Random().nextInt(colors.size()))));
        new DownloadPersonagem().execute();
    }
    private class DownloadPersonagem extends AsyncTask<Void, Void, Personagem>{

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde...", "Obtendo informações");
        }

        @Override
        protected Personagem doInBackground(Void... params) {
            Conversor util = new Conversor();
            return util.getInformacao("https://api.jikan.moe/v3/anime/1/characters_staff");
        }

        @Override
        protected void onPostExecute(Personagem personagem) {
            name.setText(personagem.getName());
            role.setText(personagem.getRole());
            avatar.setImageBitmap(personagem.getAvatar());

            Actor actor = personagem.getActor();
            actorName.setText(actor.getName());
            actorLanguage.setText(actor.getLanguage());
            actorAvatar.setImageBitmap(actor.getAvatar());

            load.dismiss(); // deletar dialogo
        }
    }
}