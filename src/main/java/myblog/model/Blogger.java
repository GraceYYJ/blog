package myblog.model;

public class Blogger {
    private String bloggerid;

    private String bloggername;

    private String password;

    public String getBloggerid() {
        return bloggerid;
    }

    public void setBloggerid(String bloggerid) {
        this.bloggerid = bloggerid == null ? null : bloggerid.trim();
    }

    public String getBloggername() {
        return bloggername;
    }

    public void setBloggername(String bloggername) {
        this.bloggername = bloggername == null ? null : bloggername.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}