package com.o_bdreldin.tracker;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public abstract class BaseTracker implements Tracker {

    private Subject<LocationEvent> locationResultSubject = PublishSubject.create();
    private TrackerOptions trackerOptions = TrackerOptions.create();

    protected Subject<LocationEvent> getLocationResultSubject() {
        return locationResultSubject;
    }

    protected void setLocationResultSubject(Subject<LocationEvent> locationResultSubject) {
        this.locationResultSubject = locationResultSubject;
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

    protected Observable<LocationEvent> getObservable() {
        return Observable.ambArray(locationResultSubject);
    }
}
