package isengard.com.br.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import isengard.com.br.myapplication.R;
import isengard.com.br.myapplication.model.Artist;
import isengard.com.br.myapplication.util.RecyclerViewOnClick;
import isengard.com.br.myapplication.util.SpotifyAdapter;


public class SpotifyFragment extends android.support.v4.app.Fragment implements RecyclerViewOnClick {
    private RecyclerView mRecyclerView;
    private List<Artist> artists;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spotify, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.pb);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_artists);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        artists = ((ArtistsActivity) getActivity()).artists;
        SpotifyAdapter adapter = new SpotifyAdapter(getActivity(), artists);
        adapter.setOnClick(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);


        return view;
    }

    @Override
    public void onClickListener(View v, int position) {
        Toast.makeText(getActivity(), "Position " + position, Toast.LENGTH_SHORT).show();
    }
}
