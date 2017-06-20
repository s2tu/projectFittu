package com.project.fittu.adapters;

import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.fittu.R;
import com.project.fittu.fragments.ExercisesFragment;

import java.util.ArrayList;

/**
 * Created by stu1 on 6/20/2017.
 */

public class SetsAdapter extends RecyclerView.Adapter<SetsAdapter.ExerciseViewHolder2>{
    LayoutInflater inflater = null;
    ArrayList<String> items= null;
    Fragment fragmain = null;

    //the items should be a <arrayList <object>>  where object containing weight/reps
    public SetsAdapter(LayoutInflater inflater,Fragment fragmain,ArrayList<String> items) {
        this.inflater = inflater;
        this.items = items;
        this.fragmain = fragmain;
    }

    @Override
    public ExerciseViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the sets layout here
        return  new ExerciseViewHolder2(inflater.inflate(R.layout.sets_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder2 holder, int position) {
        holder.bindItem(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
    static class ExerciseViewHolder2 extends RecyclerView.ViewHolder{
        //TextView info = null;
        public ExerciseViewHolder2(View itemView) {
            super(itemView);
            //info = (TextView) itemView.findViewById(R.id.label_exercise);
        }
        void bindItem(String text){
            //info.setText(text);
        }
    }
}

