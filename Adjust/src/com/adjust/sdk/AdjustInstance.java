package com.adjust.sdk;

import android.net.Uri;

/**
 * Created by pfms on 04/12/14.
 */
public class AdjustInstance {

    private String referrer;
    private ActivityHandler activityHandler;

    private static Logger getLogger() {
        return AdjustFactory.getLogger();
    }

    public void onCreate(AdjustConfig adjustConfig) {
        if (activityHandler != null) {
            getLogger().error("Adjust already initialized");
            return;
        }

        adjustConfig.referrer = this.referrer;

        activityHandler = ActivityHandler.getInstance(adjustConfig);
    }

    public void trackEvent(Event event) {
        if (!checkActivityHandler()) return;
        activityHandler.trackEvent(event);
    }

    public void onResume() {
        if (!checkActivityHandler()) return;
        activityHandler.trackSubsessionStart();
    }

    public void onPause() {
        if (!checkActivityHandler()) return;
        activityHandler.trackSubsessionEnd();
    }

    public void setEnabled(Boolean enabled) {
        if (!checkActivityHandler()) return;
        activityHandler.setEnabled(enabled);
    }

    public boolean isEnabled() {
        if (!checkActivityHandler()) return false;
        return activityHandler.isEnabled();
    }

    public void appWillOpenUrl(Uri url) {
        if (!checkActivityHandler()) return;
        activityHandler.readOpenUrl(url);
    }

    public void setReferrer(String referrer) {
        // setReferrer might be triggered before Adjust
        if (activityHandler == null) {
            // save it to inject in the config before launch
            this.referrer = referrer;
        } else {
            activityHandler.setReferrer(referrer);
        }
    }

    public void setOfflineMode(boolean enabled) {
        if (!checkActivityHandler()) return;
        activityHandler.setOfflineMode(enabled);
    }

    private boolean checkActivityHandler() {
        if (activityHandler == null) {
            getLogger().error("Please initialize Adjust by calling 'onCreate' before");
            return false;
        } else {
            return true;
        }
    }
}
