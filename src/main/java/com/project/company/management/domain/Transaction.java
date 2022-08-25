package com.project.company.management.domain;

import java.io.Serializable;

public class Transaction implements Serializable {
    /**
     * Param
     */
    private long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    private ArrayList<Employee> users; /*Es tipo de Employeed es una foranea*/
    private ArrayList<Transaction> transactions; /*Foranea*/
    private Date creatAt;
    private Date updateAt;

    /**
     * Constructor
     */
    public Transaction(long id, String name, String document, String phone, String address, ArrayList<Employee> users, ArrayList<Transaction> transactions, Date creatAt, Date updateAt) {
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
}
