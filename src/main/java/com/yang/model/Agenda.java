package com.yang.model;


import java.util.List;

public class Agenda {
    private String title;
    private String startTime;
    private String endTime;
    private List<User> participator;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<User> getParticipator() {
        return participator;
    }

    public void setParticipator(List<User> participator) {
        this.participator = participator;
    }
}
