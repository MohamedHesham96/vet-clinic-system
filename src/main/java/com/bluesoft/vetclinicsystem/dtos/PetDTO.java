package com.bluesoft.vetclinicsystem.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PetDTO {

    private int id;

    @NotNull(message = "Pet name is required")
    @NotBlank(message = "Pet name is required")
    @Size(max = 50, message = "Pet name max size is 50")
    private String name;

    @Size(max = 6, message = "Pet gender max size is 6")
    private String gender;

    private String dateOfBirth;

    @Size(max = 6, message = "Pet animal kind max size is 50")
    private String animalKind;

    @Size(max = 500, message = "Pet animal kind max size is 500")
    private String photos;

    @Max(value = 999, message = "Weight max value is 999")
    private Double weight;

    @NotNull(message = "Pet owner is required")
    private Integer ownerId;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
