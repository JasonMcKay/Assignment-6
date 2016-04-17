package com.jasonmckay.domaindrivendesignassignment6.repository.repositorySettings.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jasonmckay.domaindrivendesignassignment6.config.database.DBContract.*;
import com.jasonmckay.domaindrivendesignassignment6.domain.settings.Vehicle;
import com.jasonmckay.domaindrivendesignassignment6.factories.Manufacturer;
import com.jasonmckay.domaindrivendesignassignment6.repository.repositorySettings.RepositorySettings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JasonMckay on 17-Apr-16.
 */
public class RepositorySettingsImpl extends SQLiteOpenHelper implements RepositorySettings
{
    private SQLiteDatabase database;

    public String CREATE_QUERY = "CREATE TABLE " + DatabaseData.TABLE_NAME + "(" +
            DatabaseData.VEHICLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DatabaseData.ENGINE_TYPE + " TEXT NOT NULL, " +
            DatabaseData.DOOR_TYPE + " TEXT NOT NULL);";

    public RepositorySettingsImpl(Context context) {
        super(context, DatabaseData.DATABASE_NAME, null, DatabaseData.DATABASE_VERSION);

    }

    public void openConnectionWritable() throws SQLException
    {
        database = this.getWritableDatabase();
    }

    public void closeConnection()
    {
        this.close();
    }

    @Override
    public Manufacturer saveVehicle(Manufacturer vehicle) {
        openConnectionWritable();
        ContentValues values = new ContentValues();
        values.put(DatabaseData.VEHICLE_ID, vehicle.getVehicleID());
        values.put(DatabaseData.ENGINE_TYPE, vehicle.getEngineType());
        values.put(DatabaseData.DOOR_TYPE, vehicle.getDoorType());
        long id = database.insertOrThrow(DatabaseData.TABLE_NAME, null, values);
        Log.d("Database Operations", "Row Inserted");
        Manufacturer insertData = new Manufacturer.Builder()
                .copy(vehicle)
                .vehicleID((int)id)
                .build();
        return insertData;
    }

    @Override
    public Manufacturer modifyVehicle(Manufacturer vehicle) {
        openConnectionWritable();
        ContentValues values = new ContentValues();
        values.put(DatabaseData.VEHICLE_ID, vehicle.getVehicleID());
        values.put(DatabaseData.ENGINE_TYPE, vehicle.getEngineType());
        values.put(DatabaseData.DOOR_TYPE, vehicle.getDoorType());
        database.update(DatabaseData.TABLE_NAME,
                values,
                DatabaseData.VEHICLE_ID + " =? ",
                new String[] {String.valueOf(vehicle.getVehicleID())});
        Log.d("Database Operations", "Row Updated");
        return vehicle;
    }

    @Override
    public Manufacturer deleteVehicle(Manufacturer vehicle) {
        openConnectionWritable();
        database.delete(DatabaseData.TABLE_NAME,
                DatabaseData.VEHICLE_ID + " =? ",
                new String[]{String.valueOf(vehicle.getVehicleID())});
        Log.d("Database Operations", "Row Deleted");
        return vehicle;
    }

    @Override
    public Manufacturer findVehicle(Integer itemNumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DatabaseData.TABLE_NAME,
                new String[]{DatabaseData.VEHICLE_ID, DatabaseData.ENGINE_TYPE, DatabaseData.DOOR_TYPE},
                DatabaseData.VEHICLE_ID + " =? ",
                new String[]{String.valueOf(itemNumber)},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst())
        {
            final Manufacturer manufacturer;
            if(cursor.getString(1).equalsIgnoreCase("car")) {
                manufacturer = new Manufacturer.Builder()
                        .vehicle(cursor.getString(1), cursor.getString(2))
                        .vehicleID(cursor.getInt(0))
                        .build();
                return manufacturer;
            }
            else
            {
                manufacturer = new Manufacturer.Builder()
                        .vehicle(cursor.getString(1), cursor.getString(2))
                        .vehicleID(cursor.getInt(0))
                        .build();
                return manufacturer;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public Set<Manufacturer> findAllVehicles() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT * FROM " + DatabaseData.TABLE_NAME;
        Set<Manufacturer> manufacturerList = new HashSet<>();
        openConnectionWritable();
        Cursor cursor = db.rawQuery(selectAll, null);
        if(cursor.moveToFirst())
        {
            do{
                final Manufacturer manufacturer = new Manufacturer.Builder()
                        .vehicle(cursor.getString(1), cursor.getString(2))
                        .vehicleID(cursor.getInt(0))
                        .build();
                manufacturerList.add(manufacturer);
            }while(cursor.moveToNext());
        }
        return manufacturerList;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + DatabaseData.TABLE_NAME);
        Log.d("Database Operations", "Table Dropped");
    }

}
