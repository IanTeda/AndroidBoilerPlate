package au.id.teda.androidboilerplate.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;


/**
 * Utility used to check various connectivity status
 * @author Ian Teda
 *
 */
public class ConnectivityHelper {
	
	//private static final String DEBUG_TAG = BaseActivity.DEBUG_TAG;
	
	private ConnectivityManager mConnectivityManager;

	/** Activity context **/
    private Context mContext;

    /**
     * Class constructor
     * @param context
     */
    public ConnectivityHelper(Context context) {
    	// Set context based on activity context passed to constructor
    	mContext = context;
    	
    	mConnectivityManager = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    	
    }
    
    /**
     * Check if we have an Internet connection (3g or WiFi)
     * @return true if we do
     */
    public boolean isIntenetConnected(){
    	NetworkInfo activeNetwork = mConnectivityManager.getActiveNetworkInfo();
    	return activeNetwork.isConnectedOrConnecting();
    }
    
    /**
     * Check if we have a mobile (3g) Internet connection
     * @return
     */
    public boolean isMobileConnected(){
    	NetworkInfo mobile = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
    	if (mobile.isConnectedOrConnecting() && mobile.getDetailedState() == DetailedState.CONNECTED){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Check if we have a WiFi Internet connection
     * @return
     */
    public boolean isWifiConnected(){
    	NetworkInfo wifi = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    	if (wifi.isConnectedOrConnecting() && wifi.getDetailedState() == DetailedState.CONNECTED){
    		return true;
    	} else {
    		return false;
    	}
    }
    
}