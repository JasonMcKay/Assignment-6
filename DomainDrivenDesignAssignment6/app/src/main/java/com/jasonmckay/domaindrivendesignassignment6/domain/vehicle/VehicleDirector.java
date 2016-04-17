package com.jasonmckay.domaindrivendesignassignment6.domain.vehicle;

import com.jasonmckay.domaindrivendesignassignment6.domain.VehicleBuilderService;
import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class VehicleDirector {
    private VehicleBuilderService vehicleBuilder = null;

    public VehicleDirector(VehicleBuilderService vehicleBuilder) {
        this.vehicleBuilder = vehicleBuilder;
    }

    public void constructVehicle(String fuelType, String doorType)
    {
        vehicleBuilder.buildEngine(fuelType);
        vehicleBuilder.buildDoors(doorType);
    }

    public Vehicle getVehicle()
    {
        return vehicleBuilder.getVehicle();
    }
}
