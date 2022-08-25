package com.project.company.management.domain;

public class Transaction {
    //ATRIBUTOS

    private String concept;
    private float amount;
    private Employee user;


    //CONSTRUCTORES
    public Transaction (){}

    public Transaction(String concept, float amount, Employee user) {
        this.concept = concept;
        this.amount = amount;
        this.user = user;
    }

    //GETTERS AND SETTERS

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }


    //METODOS U OPERACIONES
}
