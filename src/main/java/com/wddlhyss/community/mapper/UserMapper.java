package com.wddlhyss.community.mapper;

import com.wddlhyss.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void insertuser(User user);
}
