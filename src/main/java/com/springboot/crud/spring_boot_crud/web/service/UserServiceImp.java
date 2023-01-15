package com.springboot.crud.spring_boot_crud.web.service;

import com.springboot.crud.spring_boot_crud.web.dao.UserDao;
import com.springboot.crud.spring_boot_crud.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }
}
