package com.bluesoft.vetclinicsystem.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OwnerDTO {

    private int id;

    @NotNull(message = "Owner name is required")
    @NotBlank(message = "Owner name is required")
    @Size(max = 50, message = "Owner name max size is 50")
    private String name;

    @NotNull(message = "Owner email is required")
    @NotBlank(message = "Owner email is required")
    @Size(max = 100, message = "Owner email max size is 50")
    private String email;

    @NotNull(message = "Owner phone is required")
    @NotBlank(message = "Owner phone is required")
    @Size(max = 11, message = "Owner phone max size is 50")
    private String phone;

    @Size(max = 6, message = "Owner gender max size is 6")
    private String gender;

    @Size(max = 100, message = "Owner address max size is 100")
    private String address;

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
}
