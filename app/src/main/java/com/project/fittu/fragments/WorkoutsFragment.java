package com.project.fittu.fragments;

import android.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.project.fittu.R;
import com.project.fittu.adapters.WorkoutAdapter;

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
            case R.id.add_workout:
                final AlertDialog.Builder dialog = new AlertDialog.Builder(this.getActivity());
                dialog.setView(R.layout.workouts_dialog);
                dialog.setTitle("Add Workout");
                dialog.show();
            default:
                return super.onOptionsItemSelected(item);

        }

    }




}
