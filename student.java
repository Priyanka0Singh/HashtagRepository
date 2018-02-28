package com.example.prac7;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class student extends Activity implements OnClickListener{

	EditText e1,e2,e3;
	Button save, show;
	SQLiteDatabase sql;
	String str1,str2,str3;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        e3=(EditText) findViewById(R.id.e3);
       
        sql=openOrCreateDatabase("INFORMATION",MODE_APPEND,null);
        sql.execSQL("CREATE TABLE IF NOT EXISTS info( name TEXT,enroll TEXT,phone TEXT )");
        save=(Button) findViewById(R.id.save);
        save.setOnClickListener( (OnClickListener)this);
        show=(Button)findViewById(R.id.button1);
        show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Cursor c=sql.rawQuery("SELECT * FROM info", null);
				Toast.makeText(getApplicationContext(), "rows:"+c.getCount(), Toast.LENGTH_LONG).show();
				while(c.moveToNext()){
					Toast.makeText(getApplicationContext(), "name:"+c.getString(0), Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	@Override
	public void onClick(View arg0) {
		if(arg0==save){
			Log.d("Some",str1+str2+str3);
			    str1=e1.getText().toString();
		        str2=e2.getText().toString();
		        str3=e3.getText().toString();
			sql.execSQL("INSERT INTO info VALUES('"+str1+"','"+str2+"','"+str3+"')");
			Toast.makeText(getApplicationContext(),str1+" "+str2+" "+str3, Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(),str1+" "+str2+" "+str3, Toast.LENGTH_LONG).show();
			
		}
		
	}
	
}
