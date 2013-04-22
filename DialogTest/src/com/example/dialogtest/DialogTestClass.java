package com.example.dialogtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class DialogTestClass extends DialogFragment{
	
	public AlertDialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    // Get the layout inflater
	    LayoutInflater inflater = getActivity().getLayoutInflater();

	    // Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    builder.setView(inflater.inflate(R.layout.edit_name, null))
	    // Add action buttons
	           .setPositiveButton("Spara", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   mListener.onDialogPositiveClick(DialogTestClass.this);
	               }
	           })
	           .setNegativeButton("Avbryt", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   mListener.onDialogPositiveClick(DialogTestClass.this);
	               }
	           });      
	    return builder.create();
    }
	
	
	public static interface MyInterface {
		public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
	}
	
	MyInterface mListener; 

	@Override
	public void onAttach(Activity activity) {
		mListener = (MyInterface) activity;
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		mListener = null;
		super.onDetach();
	}
}