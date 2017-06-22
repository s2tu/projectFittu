package com.project.fittu.adapters;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.fittu.R;
import com.project.fittu.activities.ExerciseActivity;
import com.project.fittu.dialogs.DialogDelete;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stu1 on 6/22/2017.
 */

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.RowHolder> {

    LayoutInflater inflater = null;
    Fragment fragmain = null;
    ArrayList<String> items = null;

    public WorkoutAdapter(LayoutInflater inflater, Fragment main) {
        this.inflater = inflater;
        this.fragmain = main;
        this.items = new ArrayList<>(Arrays.asList("Back and Biceps", "Chest and Tris", "workout1", "workout1", "workout1", "workout1", "workout1", "workout1", "workout1", "workout1", "workout1"));

    }

    @Override
    public RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the fragment?

        View result = inflater.inflate(R.layout.workout_row, parent, false);
        return (new RowHolder(result, fragmain, this));
    }

    @Override
    public void onBindViewHolder(RowHolder holder, int position) {
        holder.bindModel(items.get(position), items.get(position).length(), items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    public String getItem(int position) {
        return items.get(position);
    }


    static class RowHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        TextView label_exercise=null;
        TextView num_exercise = null;
        Button exercise_btn = null;
        String information = null;
        Fragment fragmain = null;
        WorkoutAdapter adapter = null;


        public RowHolder(View row, Fragment fragmain,  WorkoutAdapter adapter) {
            super(row);

            this.fragmain = fragmain;
            this.adapter = adapter;
            //row.setBackgroundResource(R.drawable.border);
            label_exercise=(TextView)row.findViewById(R.id.label_exercise);
            num_exercise=(TextView)row.findViewById(R.id.num_exercise);
            exercise_btn=(Button)row.findViewById(R.id.exercise_btn);
            //exercise_btn.setOnClickListener(this);
            row.setOnClickListener(this);
            row.setOnLongClickListener(this);

        }
        void bindModel(String exercise_name, int num_exercises, String info){
            label_exercise.setText(exercise_name);
            num_exercise.setText(Integer.toString(num_exercises));
            information = info;

        }

        @Override
        public void onClick(View view) {
            Log.d("TEST", "onClick " + getLayoutPosition ());
            if(information !=null ){// && view instanceof Button){
                //go to new activity with the information passed1
                Intent exercise_activity = new Intent(fragmain.getActivity(),ExerciseActivity.class);
                exercise_activity.putExtra("info", information);
                fragmain.startActivity(exercise_activity);
            }
        }

        @Override
        public boolean onLongClick(View view) {
            DialogInterface.OnClickListener deleteDialog = new DialogDelete(adapter, getLayoutPosition());
            AlertDialog.Builder builder = new AlertDialog.Builder(fragmain.getActivity());
            builder.setMessage("Would you want to delete \"" + adapter.getItem(getLayoutPosition()) + "\"?").setPositiveButton("Yes", deleteDialog)
                    .setNegativeButton("No", deleteDialog).show();
            return true;
        }
    }
}