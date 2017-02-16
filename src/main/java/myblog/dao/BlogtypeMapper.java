package myblog.dao;

import myblog.model.Blogtype;

public interface BlogtypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Blogtype record);

    int insertSelective(Blogtype record);

    Blogtype selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Blogtype record);

    int updateByPrimaryKey(Blogtype record);
}