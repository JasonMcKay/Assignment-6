package com.jasonmckay.domaindrivendesignassignment6.domain;

import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public interface VehicleBuilderService {
    public void buildEngine(String fuelType);
    public void buildDoors(String doorType);
    public void modifyEngine(double capacity, double liters);
    public Vehicle getVehicle();
}
