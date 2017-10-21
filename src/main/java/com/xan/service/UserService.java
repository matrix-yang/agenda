package com.xan.service;

import com.yang.dao.AgendaDao;
import com.yang.dao.UserDao;
import com.yang.model.Agenda;
import com.yang.model.User;

/**
 * Created by Administrator on 2017/9/20.
 */
public class UserService {
    private UserDao userDao = UserDao.getInstance();
    private AgendaDao agendaDao = AgendaDao.getInstance();

    public void quitMeeting(String title,String userName) {
        User user = userDao.findByName(userName);
        Agenda agenda = agendaDao.findByTitle(title);
        if (user.isParticipator()) {
            user.setParticipator(false);
            userDao.addUser(user);
            agendaDao.deleteParticipator(agenda,userName);
            agendaDao.addAgenda(agenda);
            if(agenda.getParticipator().isEmpty()) {
                agendaDao.deleteAgenda(title);
            }
        }
    }
}
