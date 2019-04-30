package com.o_bdreldin.tracker.service;

import java.io.Serializable;

/**
 * Created by Omar Bdreldin on 4/30/2019
 */
public interface OnServiceStartCommmand extends Serializable {

    void onStartCommand(Communicator communicator);
}
