package com.jasonmckay.domaindrivendesignassignment6;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;
import com.jasonmckay.domaindrivendesignassignment6.factories.Manufacturer;


import org.junit.*;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class TestManufacturerCreate
{
    private Manufacturer manufacturer;

    @Before
    public void setUp() throws Exception
    {
        System.out.println("*****In test case create*****");
    }

    @Test
    public void testName() throws Exception
    {
        manufacturer = new Manufacturer.Builder()
                .vehicle("leaded", "four door")
                .vehicleID(1)
                .build();
        manufacturer.print();
    }
}
