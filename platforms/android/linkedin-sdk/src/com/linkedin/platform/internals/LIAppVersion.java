package com.linkedin.platform.internals;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class LIAppVersion {

    public static final String LI_APP_PACKAGE_NAME = "com.linkedin.android";

    public static boolean isLIAppCurrent( Context ctx) {

        return isLIAppCurrent(ctx, LI_APP_PACKAGE_NAME);
    }

    private static boolean isLIAppCurrent( Context   ctx,  String packageName) {
        PackageManager packageManager = ctx.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return packageInfo.versionCode >= BuildConfig.LI_APP_SUPPORTED_VER_CODE;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

}
