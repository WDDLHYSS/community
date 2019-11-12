package com.wddlhyss.community.service.impl;

import com.wddlhyss.community.mapper.UserMapper;
import com.wddlhyss.community.model.User;
import com.wddlhyss.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertuser(user);
    }

    @Override
    public User findByToken(String token) {
        return userMapper.findByToken(token);
    }
}
