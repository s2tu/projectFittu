package com.project.fittu.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.project.fittu.R;
import com.project.fittu.activities.ExerciseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stu1 on 3/1/2017.
 */

public class WorkoutsFragment extends Fragment{
    private RecyclerView rv = null;
    private RecyclerView.LayoutManager mLayoutManager;
    public Animation animBlink = null;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    static class WorkoutAdapter extends RecyclerView.Adapter<WorkoutsFragment.RowHolder>{

        LayoutInflater inflater = null;
        View.OnClickListener contxt = null;
        Fragment fragmain = null;
        ArrayList<String> items  = null;{};

        WorkoutAdapter(LayoutInflater inflater, Fragment main ){
            this.inflater = inflater;
            this.fragmain =main;
            this.items = new ArrayList<>(Arrays.asList("Back and Biceps", "Chest and Tris", "workout1","workout1","workout1","workout1","workout1","workout1","workout1","workout1","workout1"));

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

        public void removeItem(int position){
            items.remove(position);
            notifyDataSetChanged();
        }
        public String getItem(int position){
            return items.get(position);
        }
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
            exercise_btn.setOnClickListener(this);
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
            if(information !=null  && view instanceof Button){
                //go to new activity with the information passed1
                Intent exercise_activity = new Intent(fragmain.getActivity(),ExerciseActivity.class);
                exercise_activity.putExtra("info", information);
                fragmain.startActivity(exercise_activity);
            }
        }

        @Override
        public boolean onLongClick(View view) {
            view.startAnimation(((WorkoutsFragment)fragmain).animBlink);
            class dialogDelete implements DialogInterface.OnClickListener{
                WorkoutAdapter adapter =null;
                int position = 0;
                dialogDelete(WorkoutAdapter adapter, int position){
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

            DialogInterface.OnClickListener deleteDialog = new dialogDelete(adapter, getLayoutPosition());
            AlertDialog.Builder builder = new AlertDialog.Builder(fragmain.getActivity());
            builder.setMessage("Would you want to delete \"" + adapter.getItem(getLayoutPosition()) + "\"?").setPositiveButton("Yes", deleteDialog)
                    .setNegativeButton("No", deleteDialog).show();
            return true;
        }
    }
}
