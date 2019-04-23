package com.o_bdreldin.tracker;

import android.location.Location;

import io.reactivex.Observer;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public abstract class BaseTracker implements Tracker {

    @Override
    public Tracker observeLocation(Observer<Location> observer) {
        return this;
    }
}
