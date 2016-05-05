package com.mycompany.fittu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.SwipeLayout;

/**
 * Created by Sonny on 5/5/2016.
 */
public class WorkoutSetRepsAdapter extends RecyclerView.Adapter<WorkoutSetRepsAdapter.ViewHolder>  {
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
                    //when the SurfaceView totally cover the BottomView.
                }
                @Override
                public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                    //you are swiping.
                }
                @Override
                public void onStartOpen(SwipeLayout layout) {

                }
                @Override
                public void onOpen(SwipeLayout layout) {
                    //when the BottomView totally show.
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

    @Override
    public WorkoutSetRepsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_setreps_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(WorkoutSetRepsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
