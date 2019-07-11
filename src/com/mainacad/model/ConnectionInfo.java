package com.mainacad.model;

import java.io.Serializable;

public class ConnectionInfo implements Comparable<ConnectionInfo>, Serializable {

    private User user;
    private Integer sessionId;
    private String userIp;
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public ConnectionInfo() {
    }

    public ConnectionInfo(Integer sessionId, String userIp, Long time, User user) {
        this.user = user;
        this.sessionId = sessionId;
        this.userIp = userIp;
        this.time = time;
    }

    @Override
    public int compareTo(ConnectionInfo connectionInfo) {
        if (this.time > connectionInfo.time){
            return 1;
        }
        else if (this.time < connectionInfo.time){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return time + " " + sessionId + " " + userIp + " " + user.getLogin() + " " +
                user.getPassword() + " " + user.getId();
    }
}
