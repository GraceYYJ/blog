package myblog.dao;

import myblog.model.Blogger;

public interface BloggerMapper {
    int deleteByPrimaryKey(String bloggerid);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    Blogger selectByPrimaryKey(String bloggerid);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKey(Blogger record);
}