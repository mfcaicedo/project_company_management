package com.project.company.management.domain.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String image;
    private String phone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee user;
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
