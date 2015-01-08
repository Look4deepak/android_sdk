//
//  Adjust.java
//  Adjust
//
//  Created by Christian Wellenbrock on 2012-10-11.
//  Copyright (c) 2012-2014 adjust GmbH. All rights reserved.
//  See the file MIT-LICENSE for copying permission.
//

package com.adjust.sdk;

import android.net.Uri;

/**
 * The main interface to Adjust.
 * <p/>
 * Use the methods of this class to tell Adjust about the usage of your app.
 * See the README for details.
 */
public class Adjust {

    private static AdjustInstance defaultInstance;

    private Adjust() {
    }

    public static synchronized AdjustInstance getInstance() {
        if (defaultInstance == null) {
            defaultInstance = new AdjustInstance();
        }
        return defaultInstance;
    }

    public static void onCreate(AdjustConfig adjustConfig) {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.onCreate(adjustConfig);
    }

    public static void trackEvent(Event event) {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.trackEvent(event);
    }

    public static void onResume() {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.onResume();
    }

    public static void onPause() {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.onPause();
    }

    public static void setEnabled(Boolean enabled) {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.setEnabled(enabled);
    }

    public static boolean isEnabled() {
        AdjustInstance adjustInstance = Adjust.getInstance();
        return adjustInstance.isEnabled();
    }

    public static void appWillOpenUrl(Uri url) {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.appWillOpenUrl(url);
    }

    public static void setReferrer(String referrer) {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.setReferrer(referrer);
    }

    public static void setOfflineMode(boolean enabled) {
        AdjustInstance adjustInstance = Adjust.getInstance();
        adjustInstance.setOfflineMode(enabled);
    }
}


