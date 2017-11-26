package com.example.eshlykov.trackwalker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by daniil on 26.11.17.
 */

public class NotificationsListenerService extends GcmListenerService {
    private static final String TAG = NotificationsListenerService.class.getSimpleName();

    @Override
    public void onMessageReceived(String from, Bundle data) {
        Bundle notification = (Bundle)data.get("notification");

        int uniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
// Handle received message here.
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, uniqueId, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            Notification newMessageNotification =
                    new Notification.Builder(getApplicationContext())
                            .setContentTitle(notification.getString("body"))
                            .setContentText(notification.getString("title"))
                            .setContentIntent(resultPendingIntent)
                            .setAutoCancel(true)
                            .build();
// Issue the notification.
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);;

        notificationManager.notify(uniqueId, newMessageNotification);
    }
}
