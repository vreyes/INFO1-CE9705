package com.android.december20vreyes;

import android.app.Activity;
import android.content.Intent;
import android.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class December20vreyesActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_list);
        
        String [] items = new String [] { "Android Homework", "Drink After Finals", "Watch Allen Gregory Episode", "Xmas Shopping" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.reminder_row, R.id.text1, items);
        setListAdapter(adapter);
        
        @Override
        protected void onListItemClick (ListView 1, View v, int position, long id) 
        
        {
        	super.onListItemClick (1, v, position, id);
           	Intent i = new Intent(this, ReminderEditActivity.class);
           	i.putExtra("RowId", id);
           	startActivity(i);
        }
       
        	
        	
        	registerForContextMenu(getListView());
          	
           	
        	@Override
        	public void onCreateContextMenu (ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        		super.onCreateContextMenu(menu, v, menuInfo);
        	}
        }
        
    }
}