package com.example.dialogsdemoversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

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
        btnAlertDialog.setOnClickListener(new BtnAlertClickListener());
    }

    class BtnAlertClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Android Batch");
            builder.setMessage("Have you completed the tasks?");
            builder.setIcon(R.drawable.ic_launcher_background);

            /*builder.setPositiveButton("Yes",new BtnPositiveClickListener());
            builder.setNeutralButton("NA",new BtnNeutralClickListener());
            builder.setNegativeButton("No",new BtnNegativeClickListener());
             */
            DialogInterface.OnClickListener listener = new AlertDialogButtonsClickListener();
            builder.setPositiveButton("Yes",listener);
            builder.setNeutralButton("NA",listener);
            builder.setNegativeButton("No",listener);

            builder.setOnCancelListener(new BtnOnCancelClickListener());
            builder.setOnDismissListener(new BtnOnDismissClickListener());

            AlertDialog loginDialog = builder.create();
            loginDialog.setCancelable(true);

            loginDialog.show();
        }
    }

    class AlertDialogButtonsClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == Dialog.BUTTON_POSITIVE){
                mt("on positive btn clicked -- $ of which -->" + which);
            }
            if(which == Dialog.BUTTON_NEUTRAL){
                mt("on positive btn clicked -- $ of which -->" + which);
            }
            if(which == Dialog.BUTTON_NEGATIVE){
                mt("on positive btn clicked -- $ of which -->" + which);
            }
        }
    }

    class BtnOnCancelClickListener implements DialogInterface.OnCancelListener{
        @Override
        public void onCancel(DialogInterface dialog) {
            mt("onCancel called");
        }
    }

    class BtnOnDismissClickListener implements DialogInterface.OnDismissListener{
        @Override
        public void onDismiss(DialogInterface dialog) {
            mt("onDismiss called");
        }
    }

    class BtnPositiveClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mt("Positive Btn Clicked -- $which" + which);
        }
    }

    class BtnNeutralClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mt("Neutral Btn Clicked -- $which" + which);
        }
    }

    class BtnNegativeClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mt("Negative Btn Clicked -- $which" + which);
        }
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

    public void mt(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}