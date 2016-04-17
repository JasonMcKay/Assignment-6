package com.jasonmckay.domaindrivendesignassignment6.factories;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public interface EngineType
{
    public abstract String fuelType();

    public abstract double getCapacity();

    public abstract void setCapacity(double capacity);

    public abstract double getOilInLiters();

    public abstract void setOilInLiters(double oilInLiters);

    public abstract String toString();
}
