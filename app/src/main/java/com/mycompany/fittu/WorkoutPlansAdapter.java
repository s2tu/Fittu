package com.mycompany.fittu;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

import butterknife.OnClick;

/**
 * Created by Sonny on 1/29/2016.
 */
public class WorkoutPlansAdapter extends RecyclerView.Adapter<WorkoutPlansAdapter.ViewHolder> {

    public WorkoutPlansAdapter() {
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        protected SwipeLayout mSwipeLayout;

        private void init_slide_menu(){
            //set show mode.
            mSwipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
            mSwipeLayout.setRightSwipeEnabled(false);
            mSwipeLayout.setLeftSwipeEnabled(false);
            //add drag edge.(If the BottomView has 'layout_gravity' attribute, this line is unnecessary)
            mSwipeLayout.addDrag(SwipeLayout.DragEdge.Bottom,mSwipeLayout.findViewWithTag("Bottom3"));
            mSwipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
                @Override
                public void onClose(SwipeLayout layout) {
                }
                @Override
                public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

                }
                @Override
                public void onStartOpen(SwipeLayout layout) {

                }
                @Override
                public void onOpen(SwipeLayout layout) {
                }
                @Override
                public void onStartClose(SwipeLayout layout) {

                }
                @Override
                public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                }
            });
        }
        public ViewHolder(View v) {
            super(v);
            mSwipeLayout = (SwipeLayout)v;
            //here we define the elements of the row
            init_slide_menu();
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WorkoutPlansAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_workout_row, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
      //  holder.mTextView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 20;
    }

}
