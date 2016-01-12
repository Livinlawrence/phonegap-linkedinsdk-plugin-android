package com.linkedin.android.mobilesdksampleapp;

import android.content.Intent;
import android.widget.Toast;

import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISession;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class LinkedINPlugin extends CordovaPlugin {
    private CallbackContext loginContext = null;
    private static final String host = "api.linkedin.com";
    private static final String topCardUrl = "https://" + host + "/v1/people/~:(id,first-name,last-name,maiden-name,formatted-name,site-standard-profile-request,industry,picture-url,picture-urls::(original),headline,email-address,location:(name),positions,date-of-birth)";

    /**
     * Constructor.
     */
    public LinkedINPlugin() {}

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // Set up the activity result callback to this class
        cordova.setActivityResultCallback(this);
    }

    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        // Set a pending callback to cordova
        loginContext = callbackContext;
        PluginResult pr = new PluginResult(PluginResult.Status.NO_RESULT);
        pr.setKeepCallback(true);
        loginContext.sendPluginResult(pr);

        setUpdateState();



        return true;
    }
    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE);
    }
    private void setUpdateState() {
        LISessionManager sessionManager = LISessionManager.getInstance(cordova.getActivity().getApplicationContext());
        LISession session = sessionManager.getSession();
        boolean accessTokenValid = session.isValid();
        if (accessTokenValid){
            getUserProfile();
        }else{
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    Toast toast = Toast.makeText(cordova.getActivity().getApplicationContext(), "Logging in ", Toast.LENGTH_LONG);
                    toast.show();
                    LISessionManager.getInstance(cordova.getActivity().getApplicationContext()).init(cordova.getActivity(), buildScope(), new AuthListener() {
                        @Override
                        public void onAuthSuccess() {
                            getUserProfile();
                        }
                        @Override
                        public void onAuthError(LIAuthError error) {
                            loginContext.error("No valid session found, must call init and login before logout.");
                        }
                    }, true);
                }
            });
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LISessionManager.getInstance( cordova.getActivity()).onActivityResult(cordova.getActivity(), requestCode, resultCode, data);
    }



    public void getUserProfile(){
        APIHelper apiHelper = APIHelper.getInstance(cordova.getActivity());
        apiHelper.getRequest(cordova.getActivity(), topCardUrl, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse s) {
                loginContext.success("Success "+s.toString());
            }

            @Override
            public void onApiError(LIApiError error) {

            }
        });
    }

}