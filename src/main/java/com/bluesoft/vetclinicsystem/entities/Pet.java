package com.bluesoft.vetclinicsystem.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PET", uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "ANIMAL_KIND")
    private String animalKind;

    @Column(name = "PHOTOS")
    private String photos;

    @Column(name = "WEIGHT")
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    public Pet() {
    }

    public Pet(int id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAnimalKind() {
        return animalKind;
    }

    public void setAnimalKind(String animalKind) {
        this.animalKind = animalKind;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
