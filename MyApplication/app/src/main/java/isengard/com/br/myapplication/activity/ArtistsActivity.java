package isengard.com.br.myapplication.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import isengard.com.br.myapplication.R;
import isengard.com.br.myapplication.api.SpotifyAPI;
import isengard.com.br.myapplication.model.Artist;
import isengard.com.br.myapplication.model.ArtistJSON;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ArtistsActivity extends ActionBarActivity {
    final static String BASE_URL = "https://mager-spotify-web.p.mashape.com";
    public List<Artist> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        Bundle param = getIntent().getExtras();
        String query = param.getString("artist");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpotifyAPI spotifyAPI = retrofit.create(SpotifyAPI.class);

        Call<ArtistJSON> service = spotifyAPI.findArtists(query);

        service.enqueue(new Callback<ArtistJSON>() {
            @Override
            public void onResponse(Response<ArtistJSON> response, Retrofit retrofit) {
                artists = response.body().getArtists();
                SpotifyFragment fragment = (SpotifyFragment) getSupportFragmentManager().findFragmentById(R.id.rv_frag);
                if(fragment == null){
                    fragment = new SpotifyFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.rl_fragment_container, fragment);
                    ft.commit();

                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("TETA", t.getMessage());

            }
        });
    }
}
