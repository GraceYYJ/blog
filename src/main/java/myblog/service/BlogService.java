package myblog.service;

import myblog.model.Blog;
import java.util.List;

public interface BlogService {  
    Blog getBlogById(Integer bloggerId);
    int insertBlog(Blog blog);
	public List getAllBlog();
}  