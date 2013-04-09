package au.id.teda.androidboilerplate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import au.id.teda.androidboilerplate.R;

public class DemoFragment extends BaseFragment  {
		
	// View inflated by fragment
	private View mFragmentView;
		
	/**
	 * Called 3rd in the fragment life cycle
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Set fragment layout to be inflated
		mFragmentView = inflater.inflate(R.layout.fragment_demo, container, false);
			
		return mFragmentView;
	}
		
	@Override
	protected void loadFragmentView(){
		// Set TextView reference
		TextView tvHeading = (TextView) mFragmentView.findViewById(R.id.fragment_a_heading);
	    
		// Set TextView text vaules
		tvHeading.setText("Demo Fragment");
	}
}
