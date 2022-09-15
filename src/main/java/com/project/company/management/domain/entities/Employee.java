package com.project.company.management.domain.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
//ME PERMITE PASAR DE UNA CLASE A UNA ENTIDAD(AMBITO BASES DATOS)
@Entity
//ME PERMITE DAR CARACTERISTICAS A LA ENTIDAD
@Table(name = "employee")
public class Employee{
    //ME PERMITE DECLARAR UN ATRIBUTO COMO LLAVE PRIMARIA
    @Id
    //ME PERMITE UTILIZAR UNA ESTRATEGIA DE GENERAR VALORES
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String name;
    //CARDINALIDAD
    //ME PERMITE RELACIONAR CLASES(ENTIDADES)
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

    public Employee(long id, String email, String name, Profile profile, Enum_RoleName role,
                    Date createdAt, Date updatedAt, Enterprise enterprise,
                    List<Transaction> transaction) {

        this.id = id;
        this.email = email;
        this.name = name;
        this.profile = profile;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.enterprise = enterprise;
        this.transaction = transaction;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
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
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @JsonBackReference
    public List<Transaction> getTransaction() {
        return transaction;
    }
    @JsonBackReference
    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}
