package isengard.com.br.myapplication.model;

/**
 * Created by sysadmin on 19/11/15.
 */
public class Info {
    private Long num_results;
    private Long limit;
    private Long offset;
    private String query;
    private String type;
    private Long page;

    public Long getNum_results() {
        return num_results;
    }

    public void setNum_results(Long num_results) {
        this.num_results = num_results;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }
}
