package com.jftshop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ThinkPad on 2018/1/30.
 */

@Entity
@Table(name = "admin")
public class Admin extends  BaseEntity {

    @Id
    protected String id;

    protected String department;
    protected String email;
    protected boolean is_enabled;
    protected boolean is_locked;
    protected String locked_date;
    protected String login_date;
    protected int login_failure_count;
    protected String login_ip;
    protected String username;
    protected String password;

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

    public boolean is_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    public boolean is_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public String getLocked_date() {
        return locked_date;
    }

    public void setLocked_date(String locked_date) {
        this.locked_date = locked_date;
    }

    public String getLogin_date() {
        return login_date;
    }

    public void setLogin_date(String login_date) {
        this.login_date = login_date;
    }

    public int getLogin_failure_count() {
        return login_failure_count;
    }

    public void setLogin_failure_count(int login_failure_count) {
        this.login_failure_count = login_failure_count;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
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
