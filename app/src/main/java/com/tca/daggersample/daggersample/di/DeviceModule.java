package com.tca.daggersample.daggersample.di;

import com.tca.daggersample.daggersample.models.ExternalStorage;
import com.tca.daggersample.daggersample.models.InternalStorage;
import com.tca.daggersample.daggersample.models.Processor;
import com.tca.daggersample.daggersample.models.SmartPhone;

import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;

/**
 * Created by TCA on 19-03-2017.
 */

@Module
public class DeviceModule {

    String deviceName;
    int internalMemory, externalMemory;

    public DeviceModule(String deviceName, int internalMemory, int externalMemory) {
        this.deviceName = deviceName;
        this.internalMemory = internalMemory;
        this.externalMemory = externalMemory;
    }

    @Provides
    SmartPhone providesSmartPhone(MembersInjector<SmartPhone> injector){
        SmartPhone smartPhone= new SmartPhone(deviceName);
        injector.injectMembers(smartPhone);
        return smartPhone;
    }

    @Provides
    InternalStorage providesInternalStorage()
    {
        return new InternalStorage(internalMemory);
    }

    @Provides
    ExternalStorage providesExternalStorage(){
        return new ExternalStorage(externalMemory);
    }

    @Provides
    Processor providesProcessor(MembersInjector<Processor> injector){
        Processor processor= new Processor();
        injector.injectMembers(processor);
        return processor;
    }


   }
