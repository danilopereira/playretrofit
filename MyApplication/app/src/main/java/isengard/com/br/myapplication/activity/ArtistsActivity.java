package isengard.com.br.myapplication.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import isengard.com.br.myapplication.R;

public class ArtistsActivity extends ActionBarActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        recyclerView = (RecyclerView) findViewById(R.id.rv_artists);
        recyclerView.setHasFixedSize(true);

        rvLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayout);

        
    }
}
