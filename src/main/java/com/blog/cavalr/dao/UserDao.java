package com.blog.cavalr.dao;

import com.blog.cavalr.entity.User;

public interface UserDao extends AbstractDao<User, String> {
    void saveUser(User user);
}
