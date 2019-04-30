package com.o_bdreldin.tracker;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/**
 * Created by Omar Bdreldin on 4/30/2019
 */
public class LocationEvent {
    public final Type type;
    private LocationResult locationResult;
    private LocationAvailability locationAvailability;

    public LocationEvent(Type type, LocationResult locationResult) {
        this.type = type;
        this.locationResult = locationResult;
    }

    public LocationEvent(Type type, LocationAvailability locationAvailability) {
        this.type = type;
        this.locationAvailability = locationAvailability;
    }

    public LocationResult getLocationResult() {
        return locationResult;
    }

    public LocationAvailability getLocationAvailability() {
        return locationAvailability;
    }

    enum Type {
        LOCATION_RESULT, LOCATION_AVAILABLITY
    }
}
