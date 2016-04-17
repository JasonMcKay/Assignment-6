package com.jasonmckay.domaindrivendesignassignment6;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.jasonmckay.domaindrivendesignassignment6.config.database.DBContract.*;
import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;
import com.jasonmckay.domaindrivendesignassignment6.factories.Manufacturer;
import com.jasonmckay.domaindrivendesignassignment6.repository.repositorySettings.RepositorySettings;
import com.jasonmckay.domaindrivendesignassignment6.repository.repositorySettings.impl.RepositorySettingsImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JasonMckay on 17-Apr-16.
 */
public class TestDatabase extends AndroidTestCase {

    RepositorySettings repository;

    public void setUp() throws Exception {
        //Create and initialize database
        repository = new RepositorySettingsImpl(this.getContext());
    }

    public void testDB() throws Exception {

        //Create and Insert an entity
        Manufacturer insertEntity = new Manufacturer.Builder()
                .vehicle("leaded", "four door")
                .build();
        Manufacturer insertData = repository.saveVehicle(insertEntity);
        Assert.assertNotNull(insertData);
        int id = insertData.getVehicleID();

        //Find an entity and save its result
        Manufacturer entity = repository.findVehicle(id);
        Assert.assertNotNull(entity);

        //Select all data from table
        Set<Manufacturer> manufacturerList = repository.findAllVehicles();
        Assert.assertTrue(manufacturerList.size() > 0);

        //Update an entity
        Manufacturer updateEntity = new Manufacturer.Builder()
                .copy(entity)
                .modifyVehicle("diesel")
                .build();
        repository.modifyVehicle(updateEntity);
        Manufacturer entity1 = repository.findVehicle(id);
        Assert.assertEquals("Diesel", entity1.getEngineType());

        //Delete an entity
        repository.deleteVehicle(updateEntity);
        Manufacturer deleteEntity = repository.findVehicle(id);
        Assert.assertNull(deleteEntity);
    }

    @Override
    public void tearDown() throws Exception {
        // Delete database after every execution to avoid errors while testing
        this.getContext().deleteDatabase(DatabaseData.DATABASE_NAME);
        super.tearDown();
    }
}
