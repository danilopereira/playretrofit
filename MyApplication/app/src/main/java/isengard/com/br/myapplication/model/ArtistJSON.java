package isengard.com.br.myapplication.model;

import java.util.List;

/**
 * Created by sysadmin on 19/11/15.
 */
public class ArtistJSON {
    private Info info;
    private List<Artist> artists;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
