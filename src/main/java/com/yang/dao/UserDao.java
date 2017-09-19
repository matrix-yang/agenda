package com.yang.dao;

import com.yang.model.User;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class UserDao {
    private List<User> users;
    private static final UserDao userDao=new UserDao();

    private UserDao(){}

    public static UserDao getInstance(){
        return userDao;
    }

    public void init(List<User> users){
        this.users=users;
    }

    public User findByName(String name){
        for (User user:users){
            if (user.getUserName().equals(name)) return user;
        }
        return null;
    }
}
