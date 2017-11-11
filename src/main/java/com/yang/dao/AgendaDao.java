package com.yang.dao;

import com.yang.model.Agenda;
import com.yang.model.User;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class AgendaDao {
    private List<Agenda> agendas;
    private static final AgendaDao agendaDao = new AgendaDao();

    private AgendaDao() {
    }

    public void init(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public static AgendaDao getInstance() {
        return agendaDao;
    }

    public Agenda findByTitle(String title) {
        for (Agenda agenda : agendas) {
            if (agenda.getTitle().equals(title)) return agenda;
        }
        return null;
    }

    public boolean addAgenda(Agenda agenda) {
        agendas.add(agenda);
        return true;
    }

    public boolean deleteAgenda(String title) {
        for (Agenda agenda : agendas) {
            if (agenda.getTitle().equals(title)) {
                agendas.remove(agenda);
                return true;
            }
        }
        return false;
    }

    public User isParticipator(Agenda agenda,String userName) {
        for ( User participator : agenda.getParticipator()) {
            if (participator.getUserName().equals(userName)) {
                return participator;
            }
        }
        return null;
    }

    public void deleteParticipator(Agenda agenda,User participator) {
                agenda.getParticipator().remove(participator);
    }
}
