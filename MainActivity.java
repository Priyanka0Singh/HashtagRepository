package com.example.prac7;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b1.setOnClickListener((OnClickListener) this);
        b2.setOnClickListener((OnClickListener) this);
        b3.setOnClickListener((OnClickListener) this);
        
    }
		

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(arg0==b1)
			{
				Intent i=new Intent(this,student.class);
				startActivity(i);
			}
			if(arg0==b2)
			{
				Intent i=new Intent(this,marks.class);
				startActivity(i);
			}
			if(arg0==b3)
			{
				Intent i=new Intent(this,sms.class);
				startActivity(i);
			}
			
		}
    
}
