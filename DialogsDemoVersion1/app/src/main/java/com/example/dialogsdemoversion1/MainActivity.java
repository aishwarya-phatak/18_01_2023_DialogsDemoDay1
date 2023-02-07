package com.example.dialogsdemoversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btnDatePickerDialog,btnTimePickerDialog,btnAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }


    private void initViews(){
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
    }


    private void initListeners(){
        btnDatePickerDialog.setOnClickListener(new BtnDatePickerClickListener());
        btnTimePickerDialog.setOnClickListener(new BtnTimePickerClickListener());
    }


    class BtnTimePickerClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity.this,
                    new MyTimeSetListener(),
                    11,
                    50,
                    true
            );

            timePickerDialog.show();
        }
    }

    class MyTimeSetListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            btnTimePickerDialog.setText(hourOfDay + ":" + minute);
            Log.e("tag","hr : mm" + hourOfDay + minute);
        }
    }

    class BtnDatePickerClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    new MyDateListener(),
                    2023,
                    1,
                    07

            );
            datePickerDialog.show();
        }
    }

    class MyDateListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            btnDatePickerDialog.setText(year + "-" + month + "-" + dayOfMonth);
            Log.e("tag","year -- month -- dayOfMonth" + year + "--" + month + "--" + dayOfMonth);
        }
    }



}