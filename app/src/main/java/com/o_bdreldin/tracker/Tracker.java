package com.o_bdreldin.tracker;

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

    Tracker onNewLocation();
}
