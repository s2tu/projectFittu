package com.project.fittu.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.fittu.R;
import com.project.fittu.activities.ExerciseActivity;

import java.util.List;

/**
 * Created by stu1 on 3/1/2017.
 */

public class WorkoutsFragment extends Fragment{
    private RecyclerView rv = null;
    private RecyclerView.LayoutManager mLayoutManager;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.workouts, container, false);
        rv = (RecyclerView) result.findViewById(R.id.workouts_layout);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(new WorkoutAdapter(inflater, this));


        return result;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.workouts_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }




    static class WorkoutAdapter extends RecyclerView.Adapter<WorkoutsFragment.RowHolder>{

        LayoutInflater inflater = null;
        View.OnClickListener contxt = null;
        Fragment fragmain = null;
        String[] items  = {"Back and Biceps"};

        WorkoutAdapter(LayoutInflater inflater, Fragment main ){
            this.inflater = inflater;
            this.fragmain =main;

        }
        @Override
        public RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return (new RowHolder(inflater.inflate(R.layout.workout_row, parent, false), fragmain));
        }

        @Override
        public void onBindViewHolder(RowHolder holder, int position) {
            holder.bindModel(items[position], items[position].length(), "passing information");
        }

        @Override
        public int getItemCount() {
            return items.length;
        }
    }

    static class RowHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView label_exercise=null;
        TextView num_exercise = null;
        Button exercise_btn = null;
        String information = null;
        Fragment fragmain = null;

        public RowHolder(View row, Fragment fragmain) {
            super(row);
            this.fragmain = fragmain;
            row.setBackgroundResource(R.drawable.border);
            label_exercise=(TextView)row.findViewById(R.id.label_exercise);
            num_exercise=(TextView)row.findViewById(R.id.num_exercise);
            exercise_btn=(Button)row.findViewById(R.id.exercise_btn);
            exercise_btn.setOnClickListener(this);
        }
        void bindModel(String exercise_name, int num_exercises, String info){
            label_exercise.setText(exercise_name);
            num_exercise.setText(Integer.toString(num_exercises));
            information = info;
        }

        @Override
        public void onClick(View view) {
            if(information !=null){
                //go to new activity with the information passed1
                Intent exercise_activity = new Intent(fragmain.getActivity(),ExerciseActivity.class);
                exercise_activity.putExtra("info", information);
                fragmain.startActivity(exercise_activity);
            }
        }
    }
}
