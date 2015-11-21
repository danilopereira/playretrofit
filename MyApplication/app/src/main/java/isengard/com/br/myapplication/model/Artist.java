package isengard.com.br.myapplication.model;

import java.io.Serializable;

/**
 * Created by danilo on 18/11/15.
 */
public class Artist implements Serializable{
    private String name;
    private String href;
    private String popularity;

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
