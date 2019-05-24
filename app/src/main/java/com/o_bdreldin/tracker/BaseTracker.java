package com.o_bdreldin.tracker;

import androidx.annotation.NonNull;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

import io.reactivex.Observer;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public abstract class BaseTracker implements Tracker {
    private LocationRequest request = LocationRequest.create();
    private Mode mode = Mode.CONTINUOUS;
    private NotificationOption notificationOption = new NotificationOption();

    @Override
    public void start(@NonNull LocationRequest request) {
        locationRequest(request).start();
    }

    @Override
    public Tracker locationRequest(@NonNull LocationRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public Tracker mode(@NonNull Mode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public Tracker observeLocationResult(@NonNull Observer<LocationResult> observer) {
        return null;
    }

    @Override
    public Tracker observeLocationAvailability(@NonNull Observer<LocationAvailability> observer) {
        return null;
    }

    @Override
    public Tracker notificationOptions(@NonNull NotificationOption option) {
        return this;
    }
}
