package isengard.com.br.myapplication.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import isengard.com.br.myapplication.R;
import isengard.com.br.myapplication.model.Artist;

/**
 * Created by danilo on 20/11/15.
 */
public class SpotifyAdapter extends RecyclerView.Adapter<SpotifyAdapter.MyViewHolder> {
    private List<Artist> artists;
    private LayoutInflater layoutInflater;

    public SpotifyAdapter(Context c, List<Artist> l) {
        this.artists =l;
        this.layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(this.getClass().getName(), "onCreateViewHolder()");
        View v = layoutInflater.inflate(R.layout.item_artist, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(this.getClass().getName(), "onBindViewHolder()");
        Double value = Double.parseDouble(artists.get(position).getPopularity()) * 100;
        String pop = value.toString() + "%";
        holder.txtNome.setText(artists.get(position).getName());
        holder.txtPop.setText(pop);
        holder.txtHref.setText(artists.get(position).getHref());
    }

    @Override
    public int getItemCount() {

        return artists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtNome;
        public TextView txtPop;
        public TextView txtHref;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtNome = (TextView) itemView.findViewById(R.id.txt_name);
            txtPop = (TextView) itemView.findViewById(R.id.txt_pop);
            txtHref = (TextView) itemView.findViewById(R.id.txt_href);

        }
    }
}
