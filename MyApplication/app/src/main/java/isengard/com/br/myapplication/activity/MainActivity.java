package isengard.com.br.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import isengard.com.br.myapplication.R;
import isengard.com.br.myapplication.api.SpotifyAPI;
import isengard.com.br.myapplication.model.Albums;
import retrofit.Call;
import retrofit.Retrofit;

public class MainActivity extends ActionBarActivity {

    final static String BASE_URL = "https://mager-spotify-web.p.mashape.com/search/1";

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
                if(editTextArtist.getText().toString() != null || editTextArtist.getText().toString().equals("")){
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .build();

                    SpotifyAPI spotifyAPI = retrofit.create(SpotifyAPI.class);

                    List<Albums> albuns = spotifyAPI.findAlbuns(editTextArtist.getText().toString());
                    for(Albums album : albuns){
                        Toast.makeText(MainActivity.this, album.getName(), Toast.LENGTH_LONG).show();
                    }
                }
                else{
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
