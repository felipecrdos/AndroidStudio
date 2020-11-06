package com.n2.api;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView id;
    private ImageView avatar;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DownloadUser download = new DownloadUser();
        name = findViewById(R.id.fieldName);
        id = findViewById(R.id.fieldId);
        avatar = findViewById(R.id.avatar);

        download.execute();
        
    }

    public void followerOnCLick(View view){
        Intent intent = new Intent( MainActivity.this, FollowerActivity.class );
        startActivity(intent);
    }
    private class DownloadUser extends AsyncTask<Void, Void, User> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde...", "Obtendo informações");
        }
        @Override
        protected User doInBackground(Void... params) {
            UserGit util = new UserGit();
            return util.getInformacao("https://api.github.com/users/giselezrossi");
        }
        @Override
        protected void onPostExecute(User user) {
            name.setText(user.getName());
            id.setText(user.getId().toString());
            avatar.setImageBitmap(user.getAvatar());
            load.dismiss();
        }
    }
    
}