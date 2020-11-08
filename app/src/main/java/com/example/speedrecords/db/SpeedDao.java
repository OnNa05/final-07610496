package com.example.speedrecords.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.speedrecords.model.Speed;

@Dao
public interface SpeedDao {

        @Query("SELECT * FROM speeds")
        Speed[] getAllUsers();

        @Query("SELECT * FROM speeds WHERE id = :id")
        Speed getUserById(int id);

        @Insert
        void addSpeed(Speed... Speeds);

        @Delete
        void deleteUser(Speed speed);
}
