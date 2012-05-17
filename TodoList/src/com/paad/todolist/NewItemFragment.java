package com.paad.todolist;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewItemFragment extends Fragment {
	
	public interface OnNewItemAddedListener {
		
		public void OnNewItemAdded(String newItem);
		
	}
	
	private OnNewItemAddedListener onNewItemAddedListener;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try {
			onNewItemAddedListener = (OnNewItemAddedListener) activity;
		} catch (ClassCastException E) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnNewItemAddedListener");
		}
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.new_item_fragment, container,
				false);

		final EditText myEditText = (EditText) view
				.findViewById(R.id.myEditText);

		myEditText.setOnKeyListener(new View.OnKeyListener() {

			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER
							|| keyCode == KeyEvent.KEYCODE_ENTER) {

						String newItem = myEditText.getText().toString();
						onNewItemAddedListener.OnNewItemAdded(newItem);
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});

		myEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (hasFocus) {
					myEditText.setText("");
				} else
					myEditText.setText(R.string.app_name);

			}
		});
		return view;
	}


}
