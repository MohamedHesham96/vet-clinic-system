package com.bluesoft.vetclinicsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OWNER", uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "PHONE", nullable = false, length = 11)
    private String phone;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    List<Pet> pets;


    public Owner() {
    }

    public Owner(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
