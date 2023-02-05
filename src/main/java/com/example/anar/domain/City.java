package com.example.anar.domain;

public class City extends Entity<Long> {

    private String name;
    private Long river_id;
    private Float minimumElevationRisk;
    private Float maximumElevationAllowed;

    public City(Long ID, String name, Long river_id, Float minimumElevationRisk, Float maximumElevationAllowed) {
        this.setId(ID);
        this.name = name;
        this.river_id = river_id;
        this.minimumElevationRisk = minimumElevationRisk;
        this.maximumElevationAllowed = maximumElevationAllowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRiver_id() {
        return river_id;
    }

    public void setRiver_id(Long river_id) {
        this.river_id = river_id;
    }

    public Float getMinimumElevationRisk() {
        return minimumElevationRisk;
    }

    public void setMinimumElevationRisk(Float minimumElevationRisk) {
        this.minimumElevationRisk = minimumElevationRisk;
    }

    public Float getMaximumElevationAllowed() {
        return maximumElevationAllowed;
    }

    public void setMaximumElevationAllowed(Float maximumElevationAllowed) {
        this.maximumElevationAllowed = maximumElevationAllowed;
    }
}
