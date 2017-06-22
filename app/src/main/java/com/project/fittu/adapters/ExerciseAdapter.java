package com.project.fittu.adapters;

import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.fittu.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stu1 on 6/22/2017.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>{
    LayoutInflater inflater = null;
    ArrayList<String> items= null;
    Fragment fragmain = null;


    public ExerciseAdapter(LayoutInflater inflater,Fragment fragmain,ArrayList<String> items) {
        this.inflater = inflater;
        this.items = items;
        this.fragmain = fragmain;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the sets layout here

        View result = inflater.inflate(R.layout.exercise_row, parent, false);
        RecyclerView rv = (RecyclerView) result.findViewById(R.id.sets_layout);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(fragmain.getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(new SetsAdapter(inflater, fragmain, new ArrayList<>(Arrays.asList("Set 1", "test", "test"))));


        return  new ExerciseViewHolder(result);
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ExerciseViewHolder extends RecyclerView.ViewHolder{
        TextView info = null;
        public ExerciseViewHolder(View itemView) {
            super(itemView);
            info = (TextView) itemView.findViewById(R.id.label_exercise);
        }
        void bindItem(String text){
            info.setText(text);
        }
    }

}
