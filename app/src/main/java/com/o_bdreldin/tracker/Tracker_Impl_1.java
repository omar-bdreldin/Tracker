package com.o_bdreldin.tracker;

/**
 * Created by Omar Bdreldin on 4/23/2019
 * This class implements the Tracker interface using Foreground Service
 */
import android.content.Context;

public final class Tracker_Impl_1 extends BaseTracker {

    private Context aContext;

    protected Tracker_Impl_1() {
    }

    protected Tracker_Impl_1(Context context) {
        this.aContext = context.getApplicationContext();
    }

    public static Tracker_Impl_1 with(Context context) {
        return new Tracker_Impl_1(context);
    }
}