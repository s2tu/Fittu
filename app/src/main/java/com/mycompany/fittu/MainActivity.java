package com.mycompany.fittu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_1) void openmap(){
        Intent workoutplans_intent = new Intent(MainActivity.this, WorkoutPlans.class);
       // workoutplans_intent.putExtra("destination_loc",destination.getText().toString());
        startActivityForResult(workoutplans_intent, 0);
    }
}
