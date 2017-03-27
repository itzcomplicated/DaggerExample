package com.tca.daggersample.daggersample.di;

import com.tca.daggersample.daggersample.DetailActivity;
import com.tca.daggersample.daggersample.SampleActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TCA on 19-03-2017.
 */


@Component(modules={DeviceModule.class})
@Singleton
public interface DeviceComponent {
    void inject(SampleActivity sampleActivity);
    void inject(DetailActivity detailActivity);
}
