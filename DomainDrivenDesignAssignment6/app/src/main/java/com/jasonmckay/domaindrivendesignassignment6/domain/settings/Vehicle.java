package com.jasonmckay.domaindrivendesignassignment6.domain.settings;

import com.jasonmckay.domaindrivendesignassignment6.factories.EngineType;
import com.jasonmckay.domaindrivendesignassignment6.factories.doors.*;

import java.io.Serializable;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class Vehicle implements Serializable
{
    private EngineType engine;
    private DoorHandler doors1 = new FourDoorHandler();
    private DoorHandler doors2 = new TwoDoorHandler();
    private DoorHandler doors3 = new NoDoorHandler();
    private String doors;
    private int id;

    public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public String getDoors() {
        return doors;
    }

    public String getFuelType()
    {
        String fuelType = engine.fuelType();
        return fuelType;
    }

    public void setDoors(String doorType) {
        doors1.setSuccessor(doors2);
        doors2.setSuccessor(doors3);

        this.doors = doors1.handleRequest(doorType);
    }

    public String toString()
    {
        if(doors.equalsIgnoreCase("no doors"))
        {
            return "Bike built!!!! \nID: " + id + "\n" + engine.toString() + "\nFuel type: " + engine.fuelType() + "\nDoors: " + doors;
        }
        else
        {
            return "Car built!!!!\nID: " + id + "\n" + engine.toString() + "\nFuel type: " + engine.fuelType() + "\nDoors: " + doors;
        }
    }

}
