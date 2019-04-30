package com.o_bdreldin.tracker.utils;

import android.util.Log;

import com.o_bdreldin.tracker.BuildConfig;

/**
 * Created by Omar Bdreldin on 4/30/2019
 */
public interface DefLog {
    static void e(String message) {
        Log.e(BuildConfig.APPLICATION_ID, message);
    }
}
