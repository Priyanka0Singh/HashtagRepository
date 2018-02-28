package com.example.live;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {
	EditText et1,et2;
	
	Button b1;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
      
        et1=(EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        b1=(Button) findViewById(R.id.button1);
        //SimpleDateFormat dformat=new SimpleDateFormat("dd-mm-yyyy");
        //Date date =new Date();
        //String today=dformat.format(date);
        //et2.setText(today);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int train=Integer.parseInt(et1.getText().toString());
				String date1=et2.getText().toString();
				Intent i=new Intent(getApplicationContext(),second.class);
				Bundle b=new Bundle();
				b.putInt("traino", train);
				b.putString("Date",date1);
				i.putExtras(b);
				startActivity(i);
				
				
				
			}
		});
        
       
        		
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
