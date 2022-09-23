package com.project.company.management.domain.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String image;
    private String phone;

    private String password;
    private Date createdAt;
    private Date updatedAt;


    public Profile() {
    }

    public Profile(long id, String image, String phone, Date createdAt, Date updatedAt, String userName, String password) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userName=userName;
        this.password=password;
    }

    public Profile(String userName, String image, String phone, String password, Date createdAt, Date updatedAt) {
        this.userName = userName;
        this.image = image;
        this.phone = phone;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Profile(String userName) {
        this.userName = userName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
