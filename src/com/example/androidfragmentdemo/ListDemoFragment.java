package com.example.androidfragmentdemo;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("NewApi")
public class ListDemoFragment extends ListFragment{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] values = new String[] { "Sandeep", "Londhe", "Android", "iOS", "PHP"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		DetailFragment frag = (DetailFragment) getFragmentManager().findFragmentById(R.id.frag_detail);
		if (frag != null && frag.isInLayout()) {
			frag.setText(getCapt(item));
		}
	}
	
	private String getCapt(String name) {
		if (name.toLowerCase().contains("sandeep")) {
			return "Sandeep Londhe";
		}
		if (name.toLowerCase().contains("londhe")) {
			return "Sandeep S Londhe";
		}
		if (name.toLowerCase().contains("Android")) {
			return "Sandeep Android";
		}
		if (name.toLowerCase().contains("ios")) {
			return "Steve Jobs";
		}
		if (name.toLowerCase().contains("php")) {
			return "PHP-MySQL";
		}
		return "???";
	}
}
