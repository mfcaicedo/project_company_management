package com.project.company.management.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "enterprise")
public class Enterprise  {
    /**
     * Atributos
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    @OneToMany(mappedBy = "enterprise")
    @JsonIgnore
    private List<Employee> users; /*Es tipo de Employeed es una foranea*/
    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transactions; /*Foranea*/
    private Date creatAt;
    private Date updateAt;

    /**
     * Constructor
     */
    public Enterprise() {

    }

    public Enterprise(long id, String name, String document, String phone, String address,
                      List<Employee> users, List<Transaction> transactions, Date creatAt,
                      Date updateAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.users = users;
        this.transactions = transactions;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }

    /**
     * Getters and setters
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //@JsonBackReference

    public List<Employee> getUsers() {
        return users;
    }
    //@JsonBackReference

    public void setUsers(List<Employee> users) {
        this.users = users;
    }
    //@JsonBackReference

    public List<Transaction> getTransactions() {
        return transactions;
    }
    //@JsonBackReference

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }



    /**
     * Métodos y operaciones
     */

}
