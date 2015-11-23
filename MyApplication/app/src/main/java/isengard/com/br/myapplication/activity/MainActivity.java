package isengard.com.br.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import isengard.com.br.myapplication.R;
import isengard.com.br.myapplication.api.SpotifyAPI;
import isengard.com.br.myapplication.model.Albums;
import isengard.com.br.myapplication.model.Artist;
import isengard.com.br.myapplication.model.ArtistJSON;
import retrofit.Call;
import retrofit.CallAdapter;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends ActionBarActivity {



    EditText editTextArtist;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextArtist = (EditText) findViewById(R.id.edit_artist);
        button = (Button) findViewById(R.id.btn_find);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextArtist.getText().toString() != null || editTextArtist.getText().toString().equals("")) {


                    String query = editTextArtist.getText().toString();
                    if (editTextArtist.getText().toString().contains(" ")) {
                        query = editTextArtist.getText().toString().replace(' ', '+');
                    }

                    Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
                    intent.putExtra("artist", query);
                    startActivity(intent);


                } else {
                    Toast.makeText(MainActivity.this, "Inform Artist", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
