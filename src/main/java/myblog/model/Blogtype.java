package myblog.model;

public class Blogtype {
    private Integer typeid;

    private String articletype;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype == null ? null : articletype.trim();
    }
}