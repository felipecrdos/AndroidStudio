package com.n2.api;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FollowerActivity extends AppCompatActivity {

    private TextView login;
    private TextView id;
    private ImageView avatar;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);

        final DownloadFollower download = new DownloadFollower();
        login = findViewById(R.id.fieldLogin);
        id = findViewById(R.id.fieldId);
        avatar = findViewById(R.id.avatar);

        download.execute();
    }

    public void backOnCLick(View view){
        Intent intent = new Intent( FollowerActivity.this, MainActivity.class );
        startActivity(intent);
    }

    private class DownloadFollower extends AsyncTask<Void, Void, Follower> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(FollowerActivity.this,
                    "Aguarde...", "Obtendo informações");
        }
        @Override
        protected Follower doInBackground(Void... params) {
            FollowerGit util = new FollowerGit();
            return util.getInformacao("https://api.github.com/users/giselezrossi/followers");
        }
        @Override
        protected void onPostExecute(Follower follower) {
            login.setText(follower.getLogin());
            id.setText(follower.getId().toString());
            avatar.setImageBitmap(follower.getAvatar());
            load.dismiss();
        }
    }
}