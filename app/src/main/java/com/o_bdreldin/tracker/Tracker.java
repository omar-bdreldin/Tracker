package com.o_bdreldin.tracker;

import androidx.annotation.NonNull;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

import io.reactivex.Observer;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public interface Tracker {

    enum Mode {
        SINGLE, CONTINUOUS
    }

    void start();

    void start(@NonNull LocationRequest request);

    void refresh(@NonNull LocationRequest locationRequest);

    void stop();

    // TODO: once a Tracker instance is created, it should be aware if the service is already running in case of CONTINUOUS Mode
    boolean isTracking();

    Tracker locationRequest(@NonNull LocationRequest request);

    Tracker mode(@NonNull Mode mode);

    Tracker observeLocationResult(@NonNull Observer<LocationResult> observer);

    Tracker observeLocationAvailability(@NonNull Observer<LocationAvailability> observer);

    Tracker apply(NotificationOption option);
}
