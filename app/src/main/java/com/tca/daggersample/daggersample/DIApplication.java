package com.tca.daggersample.daggersample;

import android.app.Application;

import com.tca.daggersample.daggersample.di.DaggerDeviceComponent;
import com.tca.daggersample.daggersample.di.DeviceComponent;
import com.tca.daggersample.daggersample.di.DeviceModule;

/**
 * Created by TCA on 12-03-2017.
 */

public class DIApplication  extends Application {

    private DeviceComponent deviceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        deviceComponent= DaggerDeviceComponent.builder()
                .deviceModule(new DeviceModule("Pixel",1024,2*1024))
                .build();

    }

    public DeviceComponent getDeviceComponent() {
        return deviceComponent;
    }
}
