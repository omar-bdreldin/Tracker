package com.o_bdreldin.tracker;

import androidx.annotation.NonNull;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public abstract class BaseTracker implements Tracker {

    private Subject<LocationResult> locationResultSubject = PublishSubject.create();
    private Subject<LocationAvailability> locationAvailabilitySubject = PublishSubject.create();
    private LocationRequest request = LocationRequest.create();
    private Mode mode = Mode.CONTINUOUS;

    protected Subject<LocationResult> getLocationResultSubject() {
        return locationResultSubject;
    }

    protected Subject<LocationAvailability> getLocationAvailabilitySubject() {
        return locationAvailabilitySubject;
    }

    @Override
    public Tracker locationRequest(@NonNull LocationRequest request) {
        this.request = request;
        return this;
    }
}
