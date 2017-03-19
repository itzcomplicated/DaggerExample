package com.tca.daggersample.daggersample.di;

import com.tca.daggersample.daggersample.SampleActivity;

import dagger.Component;

/**
 * Created by TCA on 19-03-2017.
 */

@Component(modules={DeviceModule.class})
public interface DeviceComponent {
    void inject(SampleActivity sampleActivity);
}
