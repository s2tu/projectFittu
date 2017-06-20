package com.project.fittu.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.project.fittu.R;
import com.project.fittu.adapters.SetsAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

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

    @Nullable
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

    static class ExerciseAdapter extends RecyclerView.Adapter<ExerciseViewHolder>{
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
