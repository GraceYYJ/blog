package myblog.service;

import myblog.model.Blog;

public interface BlogService {  
    Blog getBlogById(Integer bloggerId);
    int insertBlog(Blog blog);
}  