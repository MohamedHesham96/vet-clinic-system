package com.bluesoft.vetclinicsystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "CLINIC", uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "ADDRESS", nullable = false, length = 100)
    private String address;

    @Column(name = "PHONE", nullable = false, length = 11)
    private String phone;

    @Column(name = "WORKING_DAYS_HOURS", length = 100)
    private String workingDaysHours;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "SOCIAL_NETWORKS_URLS", length = 500)
    private String socialNetworksUrls;

    public Clinic() {
    }

    public Clinic(int id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingDaysHours() {
        return workingDaysHours;
    }

    public void setWorkingDaysHours(String workingDaysHours) {
        this.workingDaysHours = workingDaysHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialNetworksUrls() {
        return socialNetworksUrls;
    }

    public void setSocialNetworksUrls(String socialNetworksUrls) {
        this.socialNetworksUrls = socialNetworksUrls;
    }
}
