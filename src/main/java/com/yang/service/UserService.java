package com.yang.service;

import com.yang.dao.UserDao;
import com.yang.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */
public class UserService {
    private UserDao userDao = UserDao.getInstance();

    public boolean addUser(String userName, String passWord, String eMail, String phone) {
        if (userDao.findByName(userName) == null) {
            User user = new User();
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.seteMail(eMail);
            user.setPhone(phone);
            user.setLogin(false);
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String userName) {
        if (userDao.deleteUser(userName)) {
            return true;
        }
        return false;
    }

    public boolean login(String userName, String password) {
        User user = userDao.findByName(userName);
        if (user != null && user.getPassWord().equals(password)) {
            userDao.deleteUser(userName);
            user.setLogin(true);
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    public void logout() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            if (user.isLogin()) {
                userDao.deleteUser(user.getUserName());
                user.setLogin(false);
                userDao.addUser(user);
            }
        }
    }
}
