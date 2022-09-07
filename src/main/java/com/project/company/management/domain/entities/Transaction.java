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

    public Transaction(long id, String concept, float amount, Enterprise enterprise, Employee employee) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.enterprise = enterprise;
        this.employee = employee;
    }

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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Métodos y opereaciones
     */
}
