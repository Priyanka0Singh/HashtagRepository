package com.example.live;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class second extends Activity{
	TextView tv1,tv2,tv3;
	ListView lv;
	ArrayList<HashMap<String,String>> routeList;
	ArrayList<String> departed_station;
	ArrayList<String> name_number;
	ArrayList<String> position_train;
	Button b;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        
        tv1=(TextView) findViewById(R.id.te5);
        //tv2=(TextView) findViewById(R.id.te6);
        tv2=(TextView) findViewById(R.id.te7);
        tv3=(TextView) findViewById(R.id.te8);
        lv=(ListView) findViewById(R.id.list);
        routeList=new ArrayList<HashMap<String,String>>();
        departed_station=new ArrayList<String>();
        name_number=new ArrayList<String>();
        position_train=new ArrayList<String>();
      //  pos=new ArrayList<String>();
        new getRoute().execute();
       
        
        
        
	}
	class getRoute extends AsyncTask<Void,Void,Void>
	{

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			HttpHandler hh=new HttpHandler();
			Bundle b1=getIntent().getExtras();
	        String date1 =b1.getString("Date");
	        int train_no=b1.getInt("traino");
	        String train_no1=String.valueOf(train_no);
			String myapikey="eb1lh2c2ed";
			String url="http://api.railwayapi.com/v2/live/train/"+train_no1+"/date/"+date1+"/apikey/"+myapikey+"/";
			String jsonStr = hh.makeServiceCall(url);
			 Log.e("Something", "Response from url: " + jsonStr);
			
				 
				
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);
					String position=jsonObj.getString("position");
					String[] pos=position.split("and");
					String part1=pos[0];
					String part2=pos[1];
					position_train.add(part1);
					position_train.add(part2);
					Log.e("So1234567", "Response from JSON OBJECT: " + pos);
					
					JSONObject jsonObj1 = jsonObj.getJSONObject("train");
					String number_train=jsonObj1.getString("number");
					String name_train=jsonObj1.getString("name");
					Log.e("So1234567", "Response from JSON OBJECT: " + position);
					name_number.add(number_train);
					name_number.add(name_train);
				
				 //JSONObject train=
				 JSONArray route_node = jsonObj.getJSONArray("route");
				 Log.e("Something1234", "Response from array: " + route_node);
				 JSONObject c1 = route_node.getJSONObject(1);
				 Log.e("Response", "Response from array: " + c1);
				 Log.e("Response123", "Response from : " + c1.getString("actarr")+c1.getString("latemin"));
				 for(int i=0;i<route_node.length();i++)
				 {
					 JSONObject c = route_node.getJSONObject(i);
					 String has_arrived=c.getString("has_arrived");
					 String has_departed=c.getString("has_departed");
					 String scharr=c.getString("scharr");
					 String schdep=c.getString("schdep");
					 String actarr=c.getString("actarr");
					 String actdep=c.getString("actdep");
					 String latemin=c.getString("latemin");
					 
					 JSONObject station=c.getJSONObject("station");
					 //Log.e("Some1234567", "Response from station: " +station);
					 String name=station.getString("name");
					 String code=station.getString("code");
					 
					 if((has_departed).equals("true"))
					 {
						 departed_station.add(name);
						 
						 
					 }
					 
					 
					 
					 HashMap<String ,String> route=new HashMap<String ,String>();
					 route.put("name", name);
					 route.put("code", code);
					 if(Integer.parseInt(latemin)==0)
					 {
					 route.put("status", "On Time");
					 }
					 else
						 route.put("status", latemin+"mins");
					 route.put("actarr", actarr);
					 
					 routeList.add(route);
					 
					 
					 
		
				 }
				 Log.e("Some1234567", "Response from station: "+routeList );
				
				 
				}
				 catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				return null;
				
			
			 
			
			
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			String number_train=name_number.get(0);
			String name_train=name_number.get(1);
			tv1.setText("           "+number_train+"-"+name_train+"           ");
			String position=position_train.get(0);
			String late=position_train.get(1);
			tv2.setText(position);
			tv3.setText(late);
			
			/*if(departed_station!=null && !departed_station.isEmpty())
			 {
				 String str=departed_station.get(departed_station.size()-1);
				 tv3.setText(str);
				 //Toast.makeText(getApplicationContext(), "crossed"+str, Toast.LENGTH_LONG).show();
			 }*/
		
			
			
			
			
	    ListAdapter adapter=new SimpleAdapter(second.this, routeList,R.layout.layout1, new String[]{ "name","code","actarr","status"}, new int[]{R.id.text11, R.id.text12,R.id.text13,R.id.text14});
		lv.setAdapter(adapter);
		
		
		}

		
	}

}
