package com.example.eshlykov.trackwalker;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

/**
 * Created by daniil on 26.11.17.
 */

/* public class RegistrationService extends IntentService {
    public RegistrationService() {
        super("RegistrationService");
    }

@Override
    protected void onHandleIntent(Intent intent) {
        InstanceID myID = InstanceID.getInstance(this);
    try {
        String registrationToken = myID.getToken(
                getString(R.string.gcm_defaultSenderId),
                GoogleCloudMessaging.INSTANCE_ID_SCOPE,
                null
        );
        Log.d("Registration Token", registrationToken);
        GcmPubSub subscription = GcmPubSub.getInstance(this);
        subscription.subscribe(registrationToken, "/topics/my_little_topic", null);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
*/
public class RegistrationService extends IntentService {
    public RegistrationService() {
        super("RegistrationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        InstanceID myID = InstanceID.getInstance(this);
        try {
            String registrationToken = myID.getToken(
                    getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE,
                    null
            );
            Log.d("Registration Token", registrationToken);
            GcmPubSub subscription = GcmPubSub.getInstance(this);
            subscription.subscribe(registrationToken, "/topics/my_little_topic", null);
        } catch (Exception e) {
            Log.e("REGISTRATION ERROR", e.toString());
        }

    }

}