package com.project.fittu.dialogs;

import android.content.DialogInterface;

import com.project.fittu.adapters.WorkoutAdapter;

/**
 * Created by stu1 on 6/22/2017.
 */

public class DialogDelete implements DialogInterface.OnClickListener{
    WorkoutAdapter adapter =null;
    int position = 0;

    public DialogDelete(WorkoutAdapter adapter, int position){
        this.adapter = adapter;
        this.position = position;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                adapter.removeItem(position);
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                //No button clicked
                break;
        }
    }
}
