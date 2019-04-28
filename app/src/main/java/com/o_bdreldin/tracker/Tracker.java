package com.o_bdreldin.tracker;

import android.location.Location;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public interface Tracker {

    enum Accuracy {
        LOW, NORMAL, HIGH
    }

    interface Frequency {
        // interval of location updates in ms
        int HIGH = 1000; // 1 second
        int NORMAL = 30000; // .5 minute
        int LOW = 60000; // 1 minute
    }

    enum Mode {
        SINGLE, CONTINUOUS
    }

    void start();

    void stop();

    boolean isTracking();

    Tracker options(TrackerOptions options);

    Observable<Location> observeLocation(Observer<Location> observer);
}
