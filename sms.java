package com.example.prac7;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms extends Activity {

	EditText phn;
	Button send;
	SQLiteDatabase sql;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        phn=(EditText) findViewById(R.id.editText1);
        send=(Button) findViewById(R.id.button1);
        sql=openOrCreateDatabase("INFORMATION",MODE_APPEND,null);
        send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String s=phn.getText().toString();
				
				Cursor c=sql.rawQuery("SELECT * FROM info WHERE phone='"+s+"'", null);
				Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
				c.moveToFirst();
				String str1=c.getString(1);
				Toast.makeText(getApplicationContext(),str1, Toast.LENGTH_LONG).show();
				//c1.moveToFirst();
				if(c.getCount()>0)
				{
					Cursor c1=sql.rawQuery("SELECT  * FROM marks WHERE enroll='"+str1+"'", null);
					c1.moveToFirst();
					if(c1.getCount()>0)
					{
					
					String str12=c1.getString(0);
					String str11=c1.getString(1);
					String str2=c1.getString(2);
					String str3=c1.getString(3);
					String str4=c1.getString(4);
					String str5=c1.getString(5);
					//Toast.makeText(getApplicationContext(), "cgudgy"+str2+str3+str4, Toast.LENGTH_LONG).show();
					sendsms(s,str3+" "+str4+" "+str5);
					Toast.makeText(getApplicationContext(), "Message Sent!!", Toast.LENGTH_LONG).show();
					
					
					//Toast.makeText(getApplicationContext(),"Info"+c.getString(0)+c.getString(1), Toast.LENGTH_LONG).show();
					}
				}
	
			}

			private void sendsms(String phoneNo, String message) {
				SmsManager manager=SmsManager.getDefault();
				manager.sendTextMessage(phoneNo, null, message, null, null);
				
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
