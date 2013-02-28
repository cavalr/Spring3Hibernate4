package com.blog.cavalr.service;

import com.blog.cavalr.entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String userName);
    void saveUser(User user);
    void deleteUser(String userName);
    List<User> findUsers(String user);
}
