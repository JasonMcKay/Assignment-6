package com.jasonmckay.domaindrivendesignassignment6;

import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;
import com.jasonmckay.domaindrivendesignassignment6.factories.Manufacturer;

import org.junit.*;

/**
 * Created by JasonMckay on 17-Apr-16.
 */
public class TestManufacturerUpdate
{
    private Manufacturer manufacturer, updateManufacturer;

    @Before
    public void setUp() throws Exception
    {
        System.out.println("*****In test case update*****");
        manufacturer = new Manufacturer.Builder()
                .vehicle("leaded", "four door")
                .vehicleID(1)
                .build();
        manufacturer.print();
    }

    @Test
    public void testModifyEntity() throws Exception
    {
        Vehicle v = manufacturer.getVehicle();
        updateManufacturer = new Manufacturer.Builder()
                .copy(manufacturer)
                .modifyVehicle(2000, 5.5)
                .build();
        updateManufacturer.print();
    }
}
