package com.project.company.management.domain;

public class Employee {
    private String email;
    private String name;
    private String enterprise;
    private String role;

    private String telefono;

    public Employee() {
    }

    public Employee(String email, String name, String enterprise, String role) {
        this.email = email;
        this.name = name;
        this.enterprise = enterprise;
        this.role = role;
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

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
