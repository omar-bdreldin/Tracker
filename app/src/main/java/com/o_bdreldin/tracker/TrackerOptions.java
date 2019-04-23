package com.o_bdreldin.tracker;

/**
 * Created by Omar Bdreldin on 4/23/2019
 */
public class TrackerOptions {

    private Tracker.Accuracy accuracy = Tracker.Accuracy.HIGH;
    private int frequency = Tracker.Frequency.NORMAL;
    private Tracker.Mode mode = Tracker.Mode.CONTINUOUS;

    private TrackerOptions() {
    }

    public static TrackerOptions create() {
        return new TrackerOptions();
    }

    public TrackerOptions accuracy(Tracker.Accuracy accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    public TrackerOptions frequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public TrackerOptions mode(Tracker.Mode mode) {
        this.mode = mode;
        return this;
    }
}
