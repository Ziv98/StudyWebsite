package com.example.demo.lwh.service;

import com.example.demo.lwh.dao.UserDao;
import com.example.demo.lwh.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserbyname(String name) {
        return userDao.getUserByname(name);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userDao.getbyUsernameAndPassword(username, password);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean register(String username, String password) {
        boolean flag = verify(username);
        if (flag) {
            int a = userDao.saveUser(username, password);
            if (a == 1)
                return true;
        }
        return false;
    }

    @Override
    public boolean verify(String username) {
        Long a = userDao.isexist(username);
        System.out.println(a);
        if (a.equals(0L))
            return true;
        return false;
    }

    @Override
    public User getUserByid(Long id) {
        return userDao.getUserByid(id);
    }
}