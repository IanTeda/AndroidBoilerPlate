package au.id.teda.snowcam.helper;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class BatteryManagerHelper {
	
	//private static final String DEBUG_TAG = BaseActivity.DEBUG_TAG;

    // Battery status intent
    private Intent batteryStatus;
    
    /**
     * Class constructor
     * @param context
     */
    public BatteryManagerHelper(Context context) {
    	IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    	batteryStatus = context.registerReceiver(null, ifilter);
    	
    }
    
    /**
     * Check if the battery is being charged or full
     * @return true if charging or batter is full
     */
    public boolean isBatteryCharging(){
    	int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
    	boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
    	                     status == BatteryManager.BATTERY_STATUS_FULL;
    	return isCharging;
    }
    
    /**
     * Check if we are connected to AC power supply
     * @return true if we are connected to AC power supply
     */
    public boolean isAcPowerConnected(){
    	int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
    	boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
    	return acCharge;
    }
    
    /**
     * Check if we are connected to USB power supply
     * @return true if we are connect to USB power supply
     */
    public boolean isUsbConnected(){
    	int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
    	boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
    	return usbCharge;	
    }

}
