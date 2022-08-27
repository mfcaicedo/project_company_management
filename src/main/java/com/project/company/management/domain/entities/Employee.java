package com.project.company.management.domain.entities;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profile_id")
    private Profile profile;

    private Enum_RoleName role;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy="employee")
    private List<Transaction> transaction;

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
    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }
}
