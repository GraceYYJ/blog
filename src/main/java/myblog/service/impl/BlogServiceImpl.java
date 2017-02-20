package myblog.service.impl;  
  
import javax.annotation.Resource;  
import java.util.List;
  
import org.springframework.stereotype.Service;  
  
import myblog.dao.BlogMapper;  
import myblog.model.Blog;  
import myblog.service.BlogService;  
  
@Service("blogService")  
public class BlogServiceImpl implements BlogService {  
    @Resource
    private BlogMapper blogDao;  
    
    @Override
    public Blog getBlogById(Integer bloggerId) {  
        return blogDao.selectByPrimaryKey(bloggerId);  
    }  
    @Override
    public int insertBlog(Blog blog){
		return blogDao.insert(blog);
    }
    @Override
	public List getAllBlog() {
		return blogDao.getAllBlog();
	}
}  