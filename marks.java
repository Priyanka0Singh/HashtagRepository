package com.example.prac7;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class marks extends Activity {
	
	EditText e1,e2,e3,e4,e5;
    Button save;
    SQLiteDatabase sql;
    String str1,str2,str3,str4,str5;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mark);
        e1=(EditText) findViewById(R.id.editText1);
        e2=(EditText) findViewById(R.id.editText2);
        e3=(EditText) findViewById(R.id.editText3);
        e4=(EditText) findViewById(R.id.editText4);
        e5=(EditText) findViewById(R.id.editText5);
        
       
        save=(Button) findViewById(R.id.button1);
        sql=openOrCreateDatabase("INFORMATION",MODE_APPEND,null);
        save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				str1=e1.getText().toString();
				str2=e2.getText().toString();
				str3=e3.getText().toString();
				str4=e4.getText().toString();
				str5=e5.getText().toString();
		        Cursor c=sql.rawQuery("SELECT * FROM info WHERE enroll='"+str1+"'", null);
		        c.moveToFirst();
		        //Toast.makeText(getApplicationContext(),"enroll"+c.getString(0), Toast.LENGTH_LONG).show();
		        if(c.getCount()>0)
		        {
		           sql.execSQL("CREATE TABLE IF NOT EXISTS marks(id INTEGER PRIMARY KEY AUTOINCREMENT,enroll TEXT, subject TEXT,semester TEXT,UT1 TEXT,UT2 TEXT)");
		           sql.execSQL("INSERT INTO marks (enroll,subject,semester,UT1,UT2) VALUES('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"')");
				   //Toast.makeText(getApplicationContext(),str2+str3+str4+str5, Toast.LENGTH_LONG).show();
				   Toast.makeText(getApplicationContext(),"Data Saved Successfully!!", Toast.LENGTH_LONG).show();
		        }
				
			}
        });
        
        
        
        
        
        
	}
	
	
	
	
}
