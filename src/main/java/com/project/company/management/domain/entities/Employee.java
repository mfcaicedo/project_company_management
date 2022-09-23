package com.project.company.management.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String email;
    private String name;

    private String password;
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="profile_id")
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Enum_RoleName.class, fetch = FetchType.EAGER)
    private List<Enum_RoleName> role;
    //@Enumerated(EnumType.STRING)
    //@ElementCollection(targetClass = rol.class, fetch = FetchType.EAGER)
    //private List<rol> role;
    private Date createdAt;
    private Date updatedAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;

    @JsonIgnore
    @OneToMany(mappedBy="employee")
    private List<Transaction> transaction;

    public Employee() {

    }

    public Employee(long id, String email, String name, String password, Profile profile, List<Enum_RoleName> role, Date createdAt, Date updatedAt, Enterprise enterprise, List<Transaction> transaction) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.profile = profile;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.enterprise = enterprise;
        this.transaction = transaction;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

   public List<Enum_RoleName> getRole() {
        return role;
   }

    public void setRole(List<Enum_RoleName> role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", enterprise=" + enterprise +
                ", transaction=" + transaction +
                '}';
    }
}
