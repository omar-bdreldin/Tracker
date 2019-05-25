package com.o_bdreldin.tracker.notification;

import android.app.PendingIntent;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/**
 * Created by Omar Bdreldin on 4/30/2019
 */
public class NotificationOption {
    private final String title, content;
    private final int iconResId;

    private final int notificationId;
    private final ChannelOptions channelOptions;
    private final PendingIntent action;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getIconResId() {
        return iconResId;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public ChannelOptions getChannelOptions() {
        return channelOptions;
    }

    public PendingIntent getAction() {
        return action;
    }

    public NotificationOption(String title, String content, int iconResId, int notificationId, ChannelOptions channelOptions, PendingIntent action) {
        this.title = title;
        this.content = content;
        this.iconResId = iconResId;
        this.notificationId = notificationId;
        this.channelOptions = channelOptions;
        this.action = action;
    }

    public static class Builder {
        private String title, content;
        private int iconResId;

        private int notificationId;
        private ChannelOptions channelOptions;
        private PendingIntent action;

        public Builder title(@NonNull String title) {
            this.title = title;
            return this;
        }

        public Builder content(@NonNull String content) {
            this.content = content;
            return this;
        }

        public Builder iconResId(@DrawableRes int iconResId) {
            this.iconResId = iconResId;
            return this;
        }

        public Builder notificationId(int notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder channelOptions(ChannelOptions options) {
            this.channelOptions = options;
            return this;
        }

        public Builder action(PendingIntent intent) {
            this.action = intent;
            return this;
        }

        public NotificationOption build() {
            return new NotificationOption(title, content, iconResId, notificationId, channelOptions, action);
        }
    }
}
