package com.yang.model;


import java.util.List;

public class Agenda {
    private String tille;
    private String startTime;
    private String endTime;
    private List<String> participator;

    public String getTille() {
        return tille;
    }

    public void setTille(String tille) {
        this.tille = tille;
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

    public List<String> getParticipator() {
        return participator;
    }

    public void setParticipator(List<String> participator) {
        this.participator = participator;
    }
}
