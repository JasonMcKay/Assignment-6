package com.jasonmckay.domaindrivendesignassignment6.repository;

import java.util.Set;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public interface Repository<ManufacturerEntity, ManufacturerKey>
{
    ManufacturerEntity saveVehicle(ManufacturerEntity vehicle);
    ManufacturerEntity modifyVehicle(ManufacturerEntity vehicle);
    ManufacturerEntity deleteVehicle(ManufacturerEntity vehicle);
    ManufacturerEntity findVehicle(ManufacturerKey itemNumber);
    Set<ManufacturerEntity> findAllVehicles();
}
