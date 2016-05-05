package com.mycompany.fittu;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class WorkoutExercise extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String QUANTITY_DIALOG = "QUANTITYDIALOG";
    public DialogFragment  dialogfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_workout_exercise);
        ButterKnife.bind(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.exerciseplans_recycleview);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new WorkoutExerciseAdapter();
        mRecyclerView.setAdapter(mAdapter);
        showDialog();
    }
    void showDialog() {
        dialogfragment = dialogFragment.newInstance("Enter a Workout Name");
        dialogfragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick(Dialog d) {

        TextView workoutName = (TextView) findViewById(R.id.workoutName);
        //workoutName.setText(((dialogFragment)dialogfragment).dialogMessage);
        // Do stuff here.
        EditText test = (EditText) d.findViewById(R.id.dialog_text);
        workoutName.setText(test.getText().toString());
        Log.i("FragmentAlertDialog", "Positive click!");
        Log.i("FragmentAlertDialog",test.getText().toString());
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
    @OnClick(R.id.fab_add_exercise_2) void add_exercise(){
        System.out.println("OPEN ACTIVITY");
        startActivityForResult(new Intent(WorkoutExercise.this, WorkoutSetReps.class), 1);
    }
}
