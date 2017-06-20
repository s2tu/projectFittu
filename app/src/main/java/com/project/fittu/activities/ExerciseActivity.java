package com.project.fittu.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.project.fittu.R;
import com.project.fittu.fragments.ExercisesFragment;
import com.project.fittu.fragments.WorkoutsFragment;

/**
 * Created by stu1 on 3/2/2017.
 */

public class ExerciseActivity extends AppCompatActivity {
    EditText info= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   //     setContentView(R.layout.exercises);
        //info= (EditText) findViewById(R.id.information);
        //info.setText(getIntent().getStringExtra("info"));
        if(getFragmentManager().findFragmentById(android.R.id.content) == null){
            getFragmentManager().beginTransaction().add(android.R.id.content, new ExercisesFragment()).commit();
        }

    }
}
