package au.id.teda.androidboilerplate.activity;

import android.content.Intent;
import android.os.Bundle;
import au.id.teda.androidboilerplate.R;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

/**
 * BaseActivity laying the foundations (reused code)
 * @author Ian Teda
 *
 */
public class BaseActivity extends SherlockFragmentActivity {
	
	// Debug tag to be used for application
	public static final String DEBUG_TAG = "boiler";
	
	// Called 1st in the activity life cycle
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	// Called 2nd in the activity life cycle
    @Override
	protected void onStart() {
		super.onStart();
	}
    
	// Called 3rd in the activity life cycle
    @Override
    protected void onResume(){
    	super.onResume();
    	
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    // Handle options menu clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    		// This is called when the Home (Up) button is pressed in the Action Bar.
	        case android.R.id.home:
	            Intent i = new Intent(this, MainActivity.class);
	            i.addFlags(
	                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
	                    Intent.FLAG_ACTIVITY_NEW_TASK);
	            startActivity(i);
	            finish();
	            return true;
	    	default:
	            return super.onOptionsItemSelected(item);
        }
    }

    // Called 1st during activity destruction
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        
    	
        super.onSaveInstanceState(outState);
    }
    
    // Called 2nd during activity destruction
	@Override
    protected void onPause() {
		
        super.onPause();
	}
    
	// Called 3rd during activity destruction
	@Override
	protected void onStop() {
		
		super.onStop();
	}
	
	// Called 4th during activity destruction
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
	}

}