package com.o_bdreldin.tracker;

import android.location.Location;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public abstract class BaseTracker implements Tracker {

    private PublishSubject<Location> locationPublishSubject = PublishSubject.create();
    private TrackerOptions trackerOptions = TrackerOptions.create()
            .accuracy(Accuracy.HIGH)
            .frequency(Frequency.HIGH)
            .mode(Mode.CONTINUOUS);

    protected PublishSubject<Location> getLocationPublishSubject() {
        return locationPublishSubject;
    }

    protected void setLocationPublishSubject(PublishSubject<Location> locationPublishSubject) {
        this.locationPublishSubject = locationPublishSubject;
    }

    protected TrackerOptions getTrackerOptions() {
        return trackerOptions;
    }

    protected void setTrackerOptions(TrackerOptions trackerOptions) {
        if (trackerOptions != null)
            this.trackerOptions = trackerOptions;
    }

    @Override
    public Tracker options(TrackerOptions options) {
        this.trackerOptions = options;
        return this;
    }

    @Override
    public Observable<Location> observeLocation(Observer<Location> observer) {
        return Observable.ambArray(locationPublishSubject);
    }
}
