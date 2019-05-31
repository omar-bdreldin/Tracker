@file:JvmName("NotificationFactory")

package com.o_bdreldin.tracker.utils

import android.app.Notification
import android.content.Context
import androidx.annotation.NonNull
import androidx.core.app.NotificationCompat
import com.o_bdreldin.tracker.notification.NotificationOption

/**
 * Created by Omar Bdreldin on 5/25/2019
 */
fun createNotification(context : Context, @NonNull option : NotificationOption?) : Notification? {
    val builder = NotificationCompat.Builder(context, option?.channelOptions?.id.toString())
    builder.setContentTitle(option?.title).setContentText(option?.content).setSmallIcon(option?.iconResId!!)
    return builder.build()
}