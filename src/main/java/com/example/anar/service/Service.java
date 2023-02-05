package com.example.anar.service;

import com.example.anar.domain.City;
import com.example.anar.domain.River;
import com.example.anar.repository.CityRepository;
import com.example.anar.repository.RiverRepository;
import com.example.anar.utils.observer.Observer;
import com.example.anar.utils.utils.ChangeEvent;
import com.example.anar.validation.ValidationException;

public class Service {

    private final RiverRepository rivers;
    private final CityRepository cities;

    public Service(RiverRepository rivers, CityRepository cities) {
        this.rivers = rivers;
        this.cities = cities;
    }

    public void addChangeObserver(Observer<ChangeEvent> observer){
        rivers.addObserver(observer);
    }

    public void updateRiverAverageElevation(River river, Float newAverageElevation) throws ValidationException{
        if(newAverageElevation >= 1.0f && newAverageElevation <= 10.0f)
            rivers.updateRiverAverageElevation(river, newAverageElevation);
        else
            throw new ValidationException("Invalid values for average elevation!");
    }

    public Iterable<River> getAllRivers(){
        return rivers.findAll();
    }

    public Iterable<City> getAllSmallRiskCities(){
        return cities.findAllSmallRiskCities();
    }

    public Iterable<City> getAllMediumRiskCities(){
        return cities.findAllMediumRiskCities();
    }

    public Iterable<City> getAllHighRiskCities(){
        return cities.findAllHighRiskCities();
    }

}
