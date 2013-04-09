package au.id.teda.androidboilerplate.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.Display;

public class LayoutHelper {
	
	// Debug tag pulled from main activity
	//private static final String DEBUG_TAG = BaseActivity.DEBUG_TAG;
	
	// Application context
    private static Context mContext;
    
    /**
     * Class constructor
     * @param context = Application context being passed in
     */
    public LayoutHelper(Context context) {
    	mContext = context;
    }
    
    /**
     * Get the screen density of the device
     * @return float of device screen density
     */
	public float getScreenDensity(){
		return mContext.getResources().getDisplayMetrics().density;
	}
	
	// Convert PX to DP
	/**
	 * Convert PX value to DP
	 * @param px = PX to be converted
	 * @return float value for DP
	 */
	public float convertPxToDp (float px){
		float density = getScreenDensity();
		return px / density;
	}
	
	/**
	 * Convert DP value to PX
	 * @param dp = DP to be converted
	 * @return float value for PX
	 */
	public float convertDpToPx(float dp){
		float density = getScreenDensity();
		return dp * density;
	}
	
	// Get the screen width in DP
	/**
	 * Get the screen width in DP
	 * @return float value of screen dp width
	 */
	public float getScreenWidthDp(){
		Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
	    DisplayMetrics outMetrics = new DisplayMetrics ();
	    display.getMetrics(outMetrics);

	    float density  = getScreenDensity();
	    //float dpHeight = outMetrics.heightPixels / density;
	    float dpWidth  = outMetrics.widthPixels / density;
	    
	    return dpWidth;
	}
	
	/**
	 * Get the screen height in DP
	 * @return float value of screen dp height
	 */
	public float getScreenHeightDp(){
		Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
	    DisplayMetrics outMetrics = new DisplayMetrics ();
	    display.getMetrics(outMetrics);

	    float density  = getScreenDensity();
	    float dpHeight = outMetrics.heightPixels / density;
	    
	    return dpHeight;
	}
    
	/**
	 * Checks if the device is a tablet or a phone
	 * 
	 * @param mContext = The Activity Context.
	 * @return Returns true if the device is a Tablet
	 */
	public boolean isTabletDevice() {
	    // Verifies if the Generalized Size of the device is XLARGE to be considered a Tablet
	    boolean xlarge = ((mContext.getResources().getConfiguration().screenLayout & 
	                        Configuration.SCREENLAYOUT_SIZE_MASK) == 
	                        Configuration.SCREENLAYOUT_SIZE_XLARGE);

	    // If XLarge, checks if the generalized density is at least MDPI (160dpi)
	    if (xlarge) {
	        DisplayMetrics metrics = new DisplayMetrics();
	        Activity activity = (Activity) mContext;
	        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

	        // MDPI=160, DEFAULT=160, DENSITY_HIGH=240, DENSITY_MEDIUM=160,
	        // DENSITY_TV=213, DENSITY_XHIGH=320
	        if (metrics.densityDpi == DisplayMetrics.DENSITY_DEFAULT
	                || metrics.densityDpi == DisplayMetrics.DENSITY_HIGH
	                || metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM
	                || metrics.densityDpi == DisplayMetrics.DENSITY_TV
	                || metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH) {

	            // Yes, this is a tablet!
	            return true;
	        }
	    }

	    // No, this is not a tablet!
	    return false;
	}
}
