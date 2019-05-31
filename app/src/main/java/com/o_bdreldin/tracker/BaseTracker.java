package com.o_bdreldin.tracker;

import androidx.annotation.NonNull;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.o_bdreldin.tracker.notification.NotificationOption;

import io.reactivex.Observer;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public abstract class BaseTracker implements Tracker {
    protected LocationRequest locationRequest = LocationRequest.create();
    protected Mode mode = Mode.CONTINUOUS;
    protected NotificationOption notificationOption = new NotificationOption.Builder().build();
    protected boolean tracking = false;
    protected Observer<LocationResult> locationResultObserver;
    protected Observer<LocationAvailability> locationAvailabilityObserver;

    @Override
    public void start(@NonNull LocationRequest request) {
        locationRequest(request).start();
    }

    @Override
    public Tracker locationRequest(@NonNull LocationRequest request) {
        locationRequest = request;
        return this;
    }

    @Override
    public Tracker mode(@NonNull Mode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public Tracker observeLocationResult(@NonNull Observer<LocationResult> observer) {
        locationResultObserver = observer;
        return this;
    }

    @Override
    public Tracker observeLocationAvailability(@NonNull Observer<LocationAvailability> observer) {
        locationAvailabilityObserver = observer;
        return this;
    }

    @Override
    public Tracker notificationOptions(@NonNull NotificationOption option) {
        notificationOption = option;
        return this;
    }

    @Override
    public boolean isTracking() {
        return tracking;
    }
}
