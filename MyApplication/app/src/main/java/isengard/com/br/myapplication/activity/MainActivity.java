package isengard.com.br.myapplication.activity;

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

    final static String BASE_URL = "https://mager-spotify-web.p.mashape.com";

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
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    SpotifyAPI spotifyAPI = retrofit.create(SpotifyAPI.class);
                    String query;
                    if(editTextArtist.getText().toString().contains(" ")){
                        query = editTextArtist.getText().toString().replace(' ', '+');
                    }
                    query = editTextArtist.getText().toString();

                    Call<ArtistJSON> service = spotifyAPI.findArtists(query);

                    service.enqueue(new Callback<ArtistJSON>() {
                        @Override
                        public void onResponse(Response<ArtistJSON> response, Retrofit retrofit) {
                            List<Artist> artists = response.body().getArtists();
                            for(Artist artist : artists){
                                Log.i("TETA", artist.getName());
                            }

                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Log.e("TETA", t.getMessage());

                        }
                    });
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
