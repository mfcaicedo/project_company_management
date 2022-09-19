package com.project.company.management.domain.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String image;
    private String phone;
    private Date createdAt;
    private Date updatedAt;

    public Profile() {
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




}
