package com.dddj.dao;

import com.dddj.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author DDDJ
 **/
public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);
    List<Blog> queryBlogChoose(Map map);


}
