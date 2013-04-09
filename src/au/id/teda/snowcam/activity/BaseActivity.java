package au.id.teda.snowcam.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import au.id.teda.snowcam.R;
import au.id.teda.snowcam.fragment.AboutDialogFragment;
import au.id.teda.snowcam.helper.LayoutHelper;
import au.id.teda.snowcam.util.FontUtils;

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
	
	// Activity shared preferences
	protected SharedPreferences mSettings;
	protected SharedPreferences.Editor mEditor;
	
	// Reference layout helper class. Used to determine screen size, density, tablet etc.
	private LayoutHelper mLayoutHelper;
	
	// Called 1st in the activity life cycle
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        // Set font to Roboto on SDK < 11
    	if (Build.VERSION.SDK_INT < 11) {
    	    ViewGroup godfatherView = (ViewGroup) this.getWindow().getDecorView();
    	    FontUtils.setRobotoFont(this, godfatherView);
    	}
    	
    	mLayoutHelper = new LayoutHelper(this);
    	
		// Set up shared preferences
		mSettings = PreferenceManager.getDefaultSharedPreferences(this);
    	mEditor = mSettings.edit();

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
		getSupportMenuInflater().inflate(R.menu.menu_base, menu);
		
		return true;
	}
	
    // Handle options menu clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    		// This is called when the Home (Up) button is pressed in the Action Bar.
	        case android.R.id.home:
	            Intent i = new Intent(this, MainActivity.class);
	            i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
	            startActivity(i);
	            finish();
	            return true;
	        // Show the about dialog
	        case R.id.menu_base_about:
        		FragmentManager fm = getSupportFragmentManager();
                AboutDialogFragment mDialog = new AboutDialogFragment();
                mDialog.show(fm, "dlg_edit_name");
                return true;
            // Open the settings activity
	        case R.id.menu_base_settings:
                Intent mSettingsActivityIntent = new Intent(getBaseContext(), SettingsActivity.class);
                startActivity(mSettingsActivityIntent);
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
