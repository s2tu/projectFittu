package com.project.fittu.activities;

import android.app.Activity;
import android.os.Bundle;

import com.project.fittu.fragments.WorkoutsFragment;


/**
 * Created by stu1 on 3/1/2017.
 */

public class WorkoutsActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //load the fragment
        //setup a floating button
        if(getFragmentManager().findFragmentById(android.R.id.content) == null){
            getFragmentManager().beginTransaction().add(android.R.id.content, new WorkoutsFragment()).commit();
        }
    }
}
