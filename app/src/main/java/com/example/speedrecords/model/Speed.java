package com.example.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Locale;

@Entity(tableName = "speeds")
public class Speed {
    @PrimaryKey(autoGenerate = true)
    public final int id;

    @ColumnInfo(name = "meter")
    public final String meter;

    @ColumnInfo(name = "time")
    public final String time;

    @ColumnInfo(name = "resultStr")
    public String resultStr;

    public Speed(int id, String meter, String time) {
        this.id = id;
        this.meter = meter;
        this.time = time;
        cal();
    }
    public void cal(){
        double merterD = Double.parseDouble(meter);
        double timeD = Double.parseDouble(time);
        double result =  (((1/timeD)*merterD)*18)/5;
        resultStr = String.format(Locale.getDefault(),"%.2f",result);
    }
}
