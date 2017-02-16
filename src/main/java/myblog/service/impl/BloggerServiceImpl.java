package myblog.service.impl;  
  
import javax.annotation.Resource;  
  
import org.springframework.stereotype.Service;  
  
import myblog.dao.BloggerMapper;  
import myblog.model.Blogger;  
import myblog.service.BloggerService;  
  
@Service("bloggerService")  
public class BloggerServiceImpl implements BloggerService {  
    @Resource
    private BloggerMapper bloggerDao;  
    
    @Override
    public Blogger getBloggerById(String bloggerId) {  
        return bloggerDao.selectByPrimaryKey(bloggerId);  
    }  
   
}  