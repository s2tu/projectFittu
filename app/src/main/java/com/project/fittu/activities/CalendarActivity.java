package com.project.fittu.activities;

import android.app.Activity;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.fittu.R;


/**
 * Created by stu1 on 3/1/2017.
 */

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateDisplay = (TextView) findViewById(R.id.date_display);
        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
           @Override
            //parameters: year selected, month selected (0-11... thus +1 in display), day selected
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day){
               dateDisplay.setText("Date: " + (month+1) + "-" + day + "-" + year);
           }
        });

    }
}
