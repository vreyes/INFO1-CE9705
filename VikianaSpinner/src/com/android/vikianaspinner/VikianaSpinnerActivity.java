package com.android.vikianaspinner;


import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.*;

public class VikianaSpinnerActivity extends Activity {
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	   /*setContentView(R.layout.main);*/
	    
	    
	    setContentView(android.view.View, android.view.ViewGroup.LayoutParams);
	    Spinner spinner = (Spinner) findViewById(R.id.spinner);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.planets_array, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
	}
}

public class MyOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent,
        View view, int pos, long id) {
   
    	Toast.makeText(parent.getCount(), "The planet is " +
          parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView parent) {
      // Do nothing.
    }
}

