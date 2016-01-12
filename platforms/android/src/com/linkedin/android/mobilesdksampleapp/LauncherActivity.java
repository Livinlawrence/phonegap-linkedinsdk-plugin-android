package com.linkedin.android.mobilesdksampleapp;

/**
 * Created by livin on 1/12/2016.
 */

import android.os.Bundle;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaActivity;

public class LauncherActivity extends CordovaActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.init();
        // Set by <content src="index.html" /> in config.xml
        super.loadUrl(Config.getStartUrl());
        //super.loadUrl("file:///android_asset/www/index.html")
    }
}

