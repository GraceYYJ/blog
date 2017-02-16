package myblog.model;

import java.util.Date;

public class Blog {
    private Integer blogid;

    private String title;

    private String articletype;

    private Date pubtime;

    private String articlebody;

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype == null ? null : articletype.trim();
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public String getArticlebody() {
        return articlebody;
    }

    public void setArticlebody(String articlebody) {
        this.articlebody = articlebody == null ? null : articlebody.trim();
    }
}