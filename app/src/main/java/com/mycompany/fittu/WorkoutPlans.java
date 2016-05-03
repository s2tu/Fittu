package com.mycompany.fittu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.daimajia.swipe.SwipeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class WorkoutPlans extends Activity {
    private RecyclerView mRecyclerView;
    private WorkoutPlansAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_workout_plans);
        ButterKnife.bind(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.workoutplans_recycleview);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // specify an adapter (see also next example)
        //normally we add the data to the adapter

        // use a linear layout manager

        mAdapter = new WorkoutPlansAdapter();
        mLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };



        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
    @OnClick(R.id.fab_add_exercise) void add_exercise(){
        System.out.println("OPEN ACTIVITY");
       startActivityForResult(new Intent(WorkoutPlans.this, WorkoutExercise.class), 1);
    }


}
