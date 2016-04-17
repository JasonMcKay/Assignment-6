package com.jasonmckay.domaindrivendesignassignment6.factories.engine;

import com.jasonmckay.domaindrivendesignassignment6.factories.EngineType;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class Diesel implements EngineType
{
    private String fuelType;
    private double capacity = 1200;
    private double oilInLiters = 1.6;

    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }

    public String fuelType() {
        return "Diesel";
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getOilInLiters() {
        return oilInLiters;
    }

    public void setOilInLiters(double oilInLiters) {
        this.oilInLiters = oilInLiters;
    }

    public String toString()
    {
        return "Engine:"+"\nSize(cc): "+capacity+"\nLiters: "+oilInLiters;
    }
}
