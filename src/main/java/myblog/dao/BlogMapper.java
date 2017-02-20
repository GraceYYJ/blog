package myblog.dao;

import myblog.model.Blog;
import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer blogid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer blogid);
    
    List<Blog> getAllBlog();//getAllBlog
    
    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
}