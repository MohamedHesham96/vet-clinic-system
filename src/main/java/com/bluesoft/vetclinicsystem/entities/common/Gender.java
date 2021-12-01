package com.bluesoft.vetclinicsystem.entities.common;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    private final String gender;

    Gender(final String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
