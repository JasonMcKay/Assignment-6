package com.jasonmckay.domaindrivendesignassignment6.factories;

import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;
import com.jasonmckay.domaindrivendesignassignment6.domain.vehicle.VehicleBuilder;

import java.io.Serializable;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class Manufacturer implements Serializable{
    private static Manufacturer manufacturer = null;
    private VehicleBuilder vehicle;
    private Vehicle currentVehicle;
    //private int id;

    private Manufacturer() {
    }

    public Vehicle getVehicle()
    {
        currentVehicle = vehicle.getVehicle();
        return currentVehicle;
    }

    public void print()
    {
        vehicle.printVehicle();
    }

    public String getEngineType()
    {
        currentVehicle = vehicle.getVehicle();
        String type1 = currentVehicle.getFuelType();
        return type1;
    }

    public String getDoorType()
    {
        currentVehicle = vehicle.getVehicle();
        String type = currentVehicle.getDoors();
        return type;
    }

    public int getVehicleID()
    {
        currentVehicle = vehicle.getVehicle();
        int id = currentVehicle.getID();
        return id;
    }

    public Manufacturer(Builder builder)
    {
        this.vehicle = builder.vehicle;
    }

    public static class Builder
    {
        private VehicleBuilder vehicle;

        public Builder vehicleID(int id)
        {
            this.vehicle.vehicleID(id);
            return this;
        }

        public Builder vehicle(String engineType, String doorType)
        {
            this.vehicle = new VehicleBuilder();
            this.vehicle.buildEngine(engineType);
            this.vehicle.buildDoors(doorType);
            return this;
        }

        public Builder modifyVehicle(String fuelType)
        {
            this.vehicle.modifyEngine(fuelType);
            return this;
        }

        public Builder modifyVehicle(double capacity, double liters)
        {
            this.vehicle.modifyEngine(capacity, liters);
            return this;
        }

        public Builder copy(Manufacturer manufacturer)
        {
            this.vehicle = manufacturer.vehicle;
            return this;
        }

        public Manufacturer build()
        {
            return new Manufacturer(this);
        }
    }
}
