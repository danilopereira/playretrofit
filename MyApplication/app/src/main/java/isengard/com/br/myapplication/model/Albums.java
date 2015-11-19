package isengard.com.br.myapplication.model;

/**
 * Created by danilo on 18/11/15.
 */
public class Albums {
    private String name;
    private String popularity;
    private String href;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "name='" + name + '\'' +
                ", popularity='" + popularity + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
