package com.o_bdreldin.tracker;

/**
 * Created by Omar Bdreldin on 4/23/2019
 * This class implements the Tracker interface using Foreground Service
 */

import android.app.Application;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;

import com.google.android.gms.location.LocationRequest;
import com.o_bdreldin.tracker.service.Communicator;
import com.o_bdreldin.tracker.service.TrackerHelperService;

public final class Tracker_Impl_1 extends BaseTracker {

    private final Application application;
    private Communicator communicator;

    public Application getApplication() {
        return application;
    }

    public Tracker_Impl_1(@NonNull Application application) {
        this.application = application;
    }

    public static Tracker_Impl_1 with(@NonNull Application application) {
        return new Tracker_Impl_1(application);
    }

    @Override
    public void start() {
        Intent intent = TrackerHelperService.getStartIntent(application, communicator -> {
            this.communicator = communicator;
            communicator.observeLocationResult();
            communicator.observeLocationAvailability();
            communicator.setNotification();
            communicator.startTracking();
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            application.startForegroundService(intent);
        else application.startService(intent);
    }

    @Override
    public void refresh(@NonNull LocationRequest locationRequest) {
        if (communicator != null)
            communicator.refreshTracking(locationRequest);
    }

    @Override
    public void stop() {
        if (communicator != null)
            communicator.stopTracking();
    }

    @Override
    public boolean isTracking() {
        return false;
    }

    @Override
    public void terminate() {
        if (communicator != null)
            communicator.stopTrackingAndSelf();
    }
}