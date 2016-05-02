package com.mycompany.fittu;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by Sonny on 4/7/2016.
 */
public class WorkoutPlansLayoutTEst extends LinearLayoutManager {
    private boolean isScrollEnabled = true;
    public WorkoutPlansLayoutTEst(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled;
    }
}
