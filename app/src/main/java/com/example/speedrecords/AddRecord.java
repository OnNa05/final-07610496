package com.example.speedrecords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.speedrecords.db.AppDatabase;
import com.example.speedrecords.model.Speed;
import com.example.speedrecords.util.AppExecutors;

import java.util.Date;

public class AddRecord extends AppCompatActivity {
    EditText merterEditText;
    EditText timeEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        merterEditText = findViewById(R.id.meter_edit_text);
        timeEditText = findViewById(R.id.time_edit_text);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String merter =  merterEditText.getText().toString();
                String time = timeEditText.getText().toString();
                if(merter.isEmpty() || time.isEmpty()){
                    Toast t = Toast.makeText(
                            AddRecord.this,
                            R.string.requrired,
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else if(time.equals("0")){
                    Toast t = Toast.makeText(
                            AddRecord.this,
                            R.string.time_zero,
                            Toast.LENGTH_LONG);
                    t.show();
                }else{

                    final Speed speed = new Speed(0, merter,time);

                    AppExecutors executors = new AppExecutors();
                    executors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() { // worker thread
                            AppDatabase db = AppDatabase.getInstance(AddRecord.this);
                            db.speedDao().addSpeed(speed);
                            finish();
                        }
                    });
                }
            }
        });
    }
}