package isengard.com.br.myapplication.api;

import java.util.List;

import isengard.com.br.myapplication.model.Albums;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by danilo on 18/11/15.
 */
public interface SpotifyAPI {

    @GET("/album.json")
    List<Albums> findAlbuns(@Query("q")String artist);
}
