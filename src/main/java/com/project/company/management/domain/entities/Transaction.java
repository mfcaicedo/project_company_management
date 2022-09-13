package com.project.company.management.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    /**
     * Atributos
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String concept;
    private float amount;
    //private Employee user;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    /**
     * Constructor
     */
    public Transaction (){}

    /**
     * Getters and setters
     * @return
     */
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void setEnterprise(Enterprise enterprise){
        this.enterprise = enterprise;
    }


    /**
     * Métodos y opereaciones
     */
}
