package isengard.com.br.myapplication.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import java.util.List;

import isengard.com.br.myapplication.R;
import isengard.com.br.myapplication.model.Artist;

public class ArtistsActivity extends ActionBarActivity {
    public List<Artist> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        Bundle param = getIntent().getExtras();
        artists = (List<Artist>) param.get("artists");

        SpotifyFragment fragment = (SpotifyFragment) getSupportFragmentManager().findFragmentById(R.id.rv_frag);
        if(fragment == null){
            fragment = new SpotifyFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container, fragment);
            ft.commit();

        }
        
    }
}
