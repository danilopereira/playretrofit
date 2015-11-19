package isengard.com.br.myapplication.api;

import java.util.List;

import isengard.com.br.myapplication.model.Albums;
import isengard.com.br.myapplication.model.Artist;
import isengard.com.br.myapplication.model.ArtistJSON;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by danilo on 18/11/15.
 */
public interface SpotifyAPI {

    @Headers({
            "X-Mashape-Key : eEecxwyZfemshG89uTt8baezLD7Up1OMvp9jsnBKBUSepXxbIc",
            "Accept: text/plain"
    })

    @GET("search/1/artist.json")
    Call<ArtistJSON> findArtists(@Query("q")String artist);
}
