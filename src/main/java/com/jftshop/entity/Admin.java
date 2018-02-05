package com.jftshop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by ThinkPad on 2018/1/30.
 */

@Entity
@Table(name = "admin")
public class Admin extends  BaseEntity {


    private String id;

    private String department;
    private String email;
    private boolean isenabled;
    private boolean islocked;
    private String lockeddate;
    private String logindate;
    private int loginfailurecount;
    private String loginip;
    private String username;
    private String password;


    private String salt="100319a431619710704fb054beff402b";

    @Transient
    public String getCredentialsSalt(){
        return username + salt;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(boolean isenabled) {
        this.isenabled = isenabled;
    }

    public boolean getIslocked() {
        return islocked;
    }

    public void setIsLocked(boolean islocked) {
        this.islocked = islocked;
    }

    public String getLockeddate() {
        return lockeddate;
    }

    public void setLockeddate(String lockeddate) {
        this.lockeddate = lockeddate;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLoginDate(String logindate) {
        this.logindate = logindate;
    }

    public int getLoginfailurecount() {
        return loginfailurecount;
    }

    public void setLoginfailurecount(int login_failure_count) {
        this.loginfailurecount = loginfailurecount;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String login_ip) {
        this.loginip = login_ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
