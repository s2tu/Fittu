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
    private WorkoutPlansLayoutTEst mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_workout_plans);
        ButterKnife.bind(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.workoutplans_recycleview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);


        // specify an adapter (see also next example)
        //normally we add the data to the adapter




        // use a linear layout manager

        mAdapter = new WorkoutPlansAdapter();
        mLayoutManager = new WorkoutPlansLayoutTEst(this);

        findViewById(R.id.ScrollView01).setOnTouchListener(new View.OnTouchListener() {
            float old_mouse = 0;
            float new_mouse = 0;
            float total= 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    old_mouse =  total;
                    new_mouse = 0;
                } else {
                    old_mouse = new_mouse;
                    new_mouse = event.getY();
                    mLayoutManager.setScrollEnabled(true);
                    System.out.println("SCROLL ENABLED");
                    System.out.println(event);
                    mRecyclerView.scrollBy(0, (int)((new_mouse)));
                    total = total + (old_mouse- new_mouse);
                    System.out.println((old_mouse- new_mouse) + " " + new_mouse + " " + mRecyclerView.getScrollState());

                }
                return true;
            }
        });
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(){
            Boolean flag = false;
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e){
                mLayoutManager.setScrollEnabled(false);
                System.out.println("SCROLL DISABLE");
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e){
                System.out.println("touch event:" + e);

            }

        });

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
  //  @OnClick(R.id.fab_add_exercise) void add_exercise(){
  //     startActivityForResult(new Intent(WorkoutPlans.this, WorkoutExercise.class), 0);
  //  }


}
