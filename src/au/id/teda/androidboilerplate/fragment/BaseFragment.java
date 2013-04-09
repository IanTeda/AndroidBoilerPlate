package au.id.teda.androidboilerplate.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import au.id.teda.androidboilerplate.activity.BaseActivity;

import com.actionbarsherlock.app.SherlockFragment;

public abstract class BaseFragment extends SherlockFragment {
	
	protected final static String DEBUG_TAG = BaseActivity.DEBUG_TAG;
	
	// Activity shared preferences
	protected SharedPreferences mSettings;
	protected SharedPreferences.Editor mEditor;
			
	// Activity context to be used
	protected Context mContext;
	
	/**
	 * Called 1st in the fragment life cycle
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		// Set up shared preferences
		mSettings = PreferenceManager.getDefaultSharedPreferences(activity);
    	mEditor = mSettings.edit();
	}
	
	/**
	 * Called 2nd in the fragment life cycle
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		// Set context for fragment. Activity extends context so we get it from there
		mContext = getActivity();
	}
	
	/**
	 * Called 4th in the fragment life cycle
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		loadFragmentView();
	}
	
	protected abstract void loadFragmentView();
	
	/**
	 * Called 5th in the fragment life cycle
	 */
	@Override
	public void onResume() {
		super.onResume();
	}
	
	/**
	* Called 1st in the death of fragment
	*/
	@Override
	public void onPause() {
		super.onPause();
		
	}

}
