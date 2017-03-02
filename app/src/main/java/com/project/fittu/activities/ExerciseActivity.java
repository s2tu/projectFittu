package com.project.fittu.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.project.fittu.R;

/**
 * Created by stu1 on 3/2/2017.
 */

public class ExerciseActivity extends Activity {
    EditText info= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises);
        info= (EditText) findViewById(R.id.information);
        info.setText(getIntent().getStringExtra("info"));
    }
}
