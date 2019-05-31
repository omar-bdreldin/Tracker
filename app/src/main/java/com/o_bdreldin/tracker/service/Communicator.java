package com.o_bdreldin.tracker.service;

import android.app.Notification;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

import java.io.Serializable;

import io.reactivex.Observer;

/**
 * Created by Omar Bdreldin on 4/30/2019
 */
public interface Communicator extends Serializable {
    void setNotification(Notification notification);
    void startTracking(LocationRequest locationRequest);
    void refreshTracking(LocationRequest locationRequest);
    void stopTracking();
    void stopTrackingAndSelf();
    void observeLocationResult(Observer<LocationResult> observer);
    void observeLocationAvailability(Observer<LocationAvailability> observer);
}
