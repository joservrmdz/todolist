package com.paad.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ToDoList extends Activity  implements NewItemFragment.OnNewItemAddedListener {
	/** Called when the activity is first created. */
	
	private ArrayList<String> todoItems;
	private ArrayAdapter<String> aa;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Get References to Fragments
		FragmentManager fm = getFragmentManager();
		ToDoListFragment todoListFragment = (ToDoListFragment) fm
				.findFragmentById(R.id.TodoListFragment);

		// Create the array list of to do items
		 todoItems = new ArrayList<String>();
		int resID = R.layout.todolist_item;
		aa = new ArrayAdapter<String>(this, resID,
				todoItems);
		
		todoListFragment.setListAdapter(aa);

	}

	public void OnNewItemAdded(String newItem) {
		todoItems.add(newItem);
		aa.notifyDataSetChanged();
		
	}

}