package com.o_bdreldin.tracker;

import android.app.PendingIntent;

/**
 * Created by Omar Bdreldin on 4/30/2019
 */
public class NotificationOption {
    private final String title, content;
    private final int iconResId;

    private final int channelId, notificationId;
    private final PendingIntent action;

    public NotificationOption(String title, String content, int iconResId, int channelId
            , int notificationId, PendingIntent action) {
        this.title = title;
        this.content = content;
        this.iconResId = iconResId;
        this.channelId = channelId;
        this.notificationId = notificationId;
        this.action = action;
    }

    public static class Builder {
        private String title, content;
        private int iconResId;

        private int channelId, notificationId;
        private PendingIntent action;

        // TODO: finish builder
    }
}
