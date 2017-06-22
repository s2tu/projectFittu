package com.project.fittu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.project.fittu.R;
import com.project.fittu.adapters.ExerciseAdapter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stu1 on 3/3/2017.
 */

public class ExercisesFragment extends Fragment {
    private RecyclerView rv = null;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        this.getActivity().setTitle(getActivity().getIntent().getStringExtra("info"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.exercises, container, false);
        rv = (RecyclerView) result.findViewById(R.id.exercises_layout);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(new ExerciseAdapter(inflater,this, new ArrayList<>(Arrays.asList("DB Curls", "DB Rows"))));
        return result;
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
}
