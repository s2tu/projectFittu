package com.project.fittu.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.fittu.fragments.WorkoutsFragment;


/**
 * Created by stu1 on 3/1/2017.
 */

public class WorkoutsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //load the fragment
        //setup a floating button
        if(getFragmentManager().findFragmentById(android.R.id.content) == null){
            getFragmentManager().beginTransaction().add(android.R.id.content, new WorkoutsFragment()).commit();
        }
    }
}
