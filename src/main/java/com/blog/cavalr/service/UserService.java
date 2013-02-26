package com.blog.cavalr.service;

import com.blog.cavalr.entity.User;

public interface UserService {

    User findByUserName(String userName);
    void saveUser(User user);
    void deleteUser(String userName);
}
