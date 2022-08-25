package com.project.company.management.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String name;
    @OneToOne
    @JoinColumn(name="profile_id")
    private Profile profile;

    private List<String> role;

    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;

    @OneToMany
    @JoinColumn(name="transaction_id")
    private List<Transaction> transaction;

    private Date createdAt;
    private Date updatedAt;


    public Employee() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

}
