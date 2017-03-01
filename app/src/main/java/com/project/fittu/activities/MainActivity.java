package com.project.fittu.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.fittu.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void workoutsActivty(View button){
        startActivity(new Intent(this,WorkoutsActivity.class));
    }
    public void mealPlanActivty(View button){
        startActivity(new Intent(this,MealPlanActivity.class));
    }
    public void calendarActivity(View button){
        startActivity(new Intent(this,CalendarActivity.class));
    }
}
