package com.yang.service;

import com.yang.dao.AgendaDao;
import com.yang.dao.UserDao;
import com.yang.model.Agenda;
import com.yang.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */
public class UserService {
    private UserDao userDao = UserDao.getInstance();
    private AgendaDao agendaDao = AgendaDao.getInstance();

    public boolean addUser(String userName, String passWord, String eMail, String phone) {
        if (userDao.findByName(userName) == null) {
            User user = new User();
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.seteMail(eMail);
            user.setPhone(phone);
            user.setLogin(false);
            user.setCreator(false);
            user.setParticipator(false);
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

    public void quitMeeting(String title,String userName) {
        User user = userDao.findByName(userName);
        Agenda agenda = agendaDao.findByTitle(title);
        if (user.isParticipator()) {
            user.setParticipator(false);
            userDao.addUser(user);
            agendaDao.deleteParticipator(agenda,userName);
            agendaDao.addAgenda(agenda);
            if("0".equals(agenda.getParticipator().size()))
            {
                agendaDao.deleteAgenda(title);
            }
        }
    }
}
