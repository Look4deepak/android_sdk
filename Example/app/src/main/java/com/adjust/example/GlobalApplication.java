package com.adjust.example;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.Attribution;
import com.adjust.sdk.Logger;
import com.adjust.sdk.OnFinishedListener;

/**
 * Created by pfms on 17/12/14.
 */
public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // configure Adjust
        String appToken = "{appToken}";
        String environment = AdjustConfig.SANDBOX_ENVIRONMENT;
        AdjustConfig config = AdjustConfig.getInstance(this, appToken, environment);

        // change the log level
        config.setLogLevel(Logger.LogLevel.VERBOSE);

        // enable event buffering
        //config.setEventBufferingEnabled(true);

        // set default tracker
        //config.setDefaultTracker("{YourDefaultTracker}");

        // set attribution delegate
        config.setOnFinishedListener(new OnFinishedListener() {
            @Override
            public void onFinishedTracking(Attribution attribution) {
                Log.d("Example", attribution.toString());
            }
        });

        Adjust.onCreate(config);

        // register onResume and onPause events of all activities
        // for applications with minimum support of Android v4 or greater
        //registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());

        // put the SDK in offline mode
        //Adjust.setOfflineMode(true);

        // disable the SDK
        //Adjust.setEnabled(false);
    }

    /*
    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }
    }
    */


}
