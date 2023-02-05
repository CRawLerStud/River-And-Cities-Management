package com.example.anar.domain;

public class River extends Entity<Long> {

    private String name;
    private Float averageElevation;

    public River(Long ID, String name, float averageElevation) {
        this.setId(ID);
        this.name = name;
        this.averageElevation = averageElevation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAverageElevation() {
        return averageElevation;
    }

    public void setAverageElevation(Float averageElevation) {
        this.averageElevation = averageElevation;
    }
}
