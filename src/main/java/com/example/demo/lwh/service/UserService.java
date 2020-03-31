package com.example.demo.lwh.service;

import com.example.demo.lwh.po.User;

public interface UserService {
    User getUserbyname(String name);
    boolean login(String username,String password);
    public boolean register(String username,String password);
    public boolean verify(String username);
    public User getUserByid(Long id);
}
