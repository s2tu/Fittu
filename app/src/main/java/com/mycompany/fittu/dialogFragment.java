package com.mycompany.fittu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.app.DialogFragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sonny on 5/4/2016.
 */
public  class dialogFragment extends DialogFragment {

    public static dialogFragment newInstance(String title) {
        dialogFragment frag = new dialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       // String title = getArguments().getInt("title");
        setCancelable(false);
        final Dialog  dialog = new Dialog ((WorkoutExercise)getActivity()){

            //for losing focus on text box
            @Override
            public boolean dispatchTouchEvent(MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    View v = getCurrentFocus();
                    if ( v instanceof EditText) {
                        Rect outRect = new Rect();
                        v.getGlobalVisibleRect(outRect);
                        if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                            v.clearFocus();
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                        }
                    }
                }
                return super.dispatchTouchEvent( event );
            }

        };
        dialog.setContentView(R.layout.dialog_fragment);
        dialog.setTitle("Test");
        dialog.setCancelable(false);

        //deselect text box after enter
        final EditText dialogtext = (EditText) dialog.findViewById(R.id.dialog_text);
        dialogtext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    //Clear focus here from edittext
                    dialogtext.clearFocus();
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return false;
            }
        });

        //creating button so that positive press is overided
        Button dialogButton = (Button) dialog.findViewById(R.id.confirm_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((WorkoutExercise)getActivity()).doPositiveClick();
                dialog.dismiss();
            }
        });


        return dialog;
    }

}


