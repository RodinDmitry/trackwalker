package com.example.eshlykov.trackwalker;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by daniil on 26.11.17.
 */

public class TokenRefreshListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        Intent i = new Intent(this, RegistrationService.class);
        startService(i);
    }
}
