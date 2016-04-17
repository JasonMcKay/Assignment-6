package com.jasonmckay.domaindrivendesignassignment6.domain.vehicle;

import com.jasonmckay.domaindrivendesignassignment6.domain.VehicleBuilderService;
import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;
import com.jasonmckay.domaindrivendesignassignment6.factories.EngineType;
import com.jasonmckay.domaindrivendesignassignment6.factories.engine.EngineFactory;

import java.io.Serializable;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class VehicleBuilder implements VehicleBuilderService
{
    private Vehicle vehicle;
    private EngineFactory engine;
    private EngineType engineType;

    public VehicleBuilder()
    {
        vehicle = new Vehicle();
        engine = EngineFactory.getEngineFactoryInstance();
    }

    public void vehicleID(int id)
    {
        vehicle.setID(id);
    }

    public void buildEngine(String fuelType)
    {
        engineType = engine.getEngineType(fuelType);
        vehicle.setEngine(engineType);
    }

    public void modifyEngine(String fuelType)
    {
        engineType = engine.getEngineType(fuelType);
        vehicle.setEngine(engineType);
    }

    public void modifyEngine(double capacity, double liters)
    {
        engineType.setCapacity(capacity);
        engineType.setOilInLiters(liters);
    }

    public void buildDoors(String doorType) {
        vehicle.setDoors(doorType);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void printVehicle()
    {
        System.out.println(vehicle.toString());
    }
}
