package com.cordova.plugin.callservice;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.util.Log;

public class CallService extends CordovaPlugin {
  private static final String POWER_TUTOR_SERVICE = "edu.umich.PowerTutor.service.UMLoggerService";
  private Intent serviceIntent;

  public CallService() {
    serviceIntent = new Intent();
    serviceIntent.setAction(POWER_TUTOR_SERVICE);
  }

  public void startPowerService(String testDescription) {
    serviceIntent.putExtra("testDescription", "PhoneGap_" + testDescription);
    cordova.getActivity().startService(serviceIntent);
  }

  public void stopPowerService() {
    cordova.getActivity().stopService(serviceIntent);
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
    Log.v("masterthesis, plugin", "Called execute of CallService plugin with action: " + action + " and arguments "
        + args.toString());
    try {
      if (action.equals("start")) {
        this.startPowerService(args.getString(0));
        callbackContext.success();
        return true;
      } else if (action.equals("stop")) {
        this.stopPowerService();
        callbackContext.success();
        return true;
      } else {
        return false;
      }
    } catch (JSONException e) {
      Log.e("masterthesis, plugin", e.getMessage());
    }

    return false;
  }
}
