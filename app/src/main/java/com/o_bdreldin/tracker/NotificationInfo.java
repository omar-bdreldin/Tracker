package com.o_bdreldin.tracker;

/**
 * Created by Omar Bdreldin on 4/30/2019
 */
public class NotificationInfo {
    public final String title, content;
    public final int iconResId;

    public NotificationInfo(String title, String content, int iconResId) {
        this.title = title;
        this.content = content;
        this.iconResId = iconResId;
    }
}
