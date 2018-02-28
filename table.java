package com.example.live;

import java.util.ArrayList;
import java.util.HashMap;




import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class table extends ArrayAdapter<HashMap<String,String>>{
	Activity context;
	View rowView;
	HashMap<String, String> hm;
	table(Context context2,ArrayList<HashMap<String,String>> object)
	
	{
		super(context2, R.layout.layout1,object);
		this.context=(Activity) context2;
	
	}
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);
		if(view==null){
			LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
			rowView= inflater.inflate(R.layout.layout1, parent, false);
		}
		else{
			rowView=view;
		}
		TextView station_name=(TextView) rowView.findViewById(R.id.text11);
		TextView code=(TextView) rowView.findViewById(R.id.text12);
		TextView eta=(TextView) rowView.findViewById(R.id.text13);
		TextView status=(TextView) rowView.findViewById(R.id.text14);
		
		hm=getItem(position);
		station_name.setText(hm.get("name"));
		code.setText(hm.get("code"));
		eta.setText(hm.get("actarr"));
		status.setText(hm.get("latemin"));
		
	    return rowView;	
	}
	
	
	

}
