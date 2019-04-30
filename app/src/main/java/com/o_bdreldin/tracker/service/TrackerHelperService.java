package com.o_bdreldin.tracker.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.o_bdreldin.tracker.utils.DefLog;

import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class TrackerHelperService extends Service {

    private Subject<LocationResult> locationResultSubject = PublishSubject.create();
    private Subject<LocationAvailability> locationAvailabilitySubject = PublishSubject.create();
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;

    public TrackerHelperService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        OnServiceStartCommmand onServiceStartCommmand = (OnServiceStartCommmand) intent.getSerializableExtra("");
        if (onServiceStartCommmand != null) {
            onServiceStartCommmand.onStartCommand(communicator);
        }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // initialization
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    public static Intent getStartIntent(@NonNull Context context
            , @NonNull OnServiceStartCommmand onServiceStartCommmand) {
        Intent intent = new Intent(context, TrackerHelperService.class);
        intent.putExtra("", onServiceStartCommmand);
        return intent;
    }

    private Communicator communicator = new Communicator() {
        @Override
        public void setNotification(Notification notification) {
            startForeground(0, notification);
        }

        @Override
        public void startTracking() {

        }

        @Override
        public void startTracking(LocationRequest locationRequest) {
            TrackerHelperService.this.locationRequest = locationRequest;
            if (fusedLocationProviderClient != null) {
                fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
            }
        }

        @Override
        public void refreshTracking(LocationRequest locationRequest) {

        }

        @Override
        public void stopTracking() {

        }

        @Override
        public void stopTrackingAndSelf() {
            stopTracking();
            stopForeground(true);
            stopSelf();
        }

        @Override
        public Observer<LocationResult> observeLocationResult(Observer<LocationResult> observer) {
            return locationResultSubject.subscribeWith(observer);
        }

        @Override
        public Observer<LocationAvailability> observeLocationAvailability(Observer<LocationAvailability> observer) {
            return locationAvailabilitySubject.subscribeWith(observer);
        }
    };

    private LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
        }

        @Override
        public void onLocationAvailability(LocationAvailability locationAvailability) {
            super.onLocationAvailability(locationAvailability);
        }
    };
}
