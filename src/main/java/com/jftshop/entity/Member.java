package com.jftshop.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * Created by ThinkPad on 2018/1/31.
 */

@Entity
@Table(name = "member")
public class Member extends  BaseEntity  {

    @Id
    protected String id;
    protected String username;
    protected String name;
    protected String password;
    protected String address;
    protected String email;
    protected String mobile;
    protected String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotEmpty
    @Pattern(regexp="^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$")
    @Column(nullable=false, updatable=false, unique=true)
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    @Pattern(regexp="^[^\\s&\"<>]+$")
    @Column(nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotEmpty
    @Email
    @Length(max=200)
    @Column(nullable=false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(max=200)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Length(max=200)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
