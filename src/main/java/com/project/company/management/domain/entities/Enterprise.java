package com.project.company.management.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Enterprise {
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
    private ArrayList<Employee> users; /*Es tipo de Employeed es una foranea*/
    @OneToMany(mappedBy = "enterprise")
    private ArrayList<Transaction> transactions; /*Foranea*/
    private Date creatAt;
    private Date updateAt;

    /**
     * Constructor
     */
    public Enterprise() {

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

    public ArrayList<Employee> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Employee> users) {
        this.users = users;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
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
