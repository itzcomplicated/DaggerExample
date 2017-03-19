package com.tca.daggersample.daggersample.models;

import javax.inject.Inject;

/**
 * Created by TCA on 19-03-2017.
 */

public class SmartPhone {

    Processor processor;

    String name;

    public SmartPhone(String name) {
        this.name = name;
    }

    @Inject
    ExternalStorage externalStorage;

    @Inject
    public SmartPhone(Processor processor) {
        this.processor=processor;
    }

    public  String getDeviceInfo(){
        String deviceInfo;
        deviceInfo = name + " Details \n";
        deviceInfo += processor.getInfo();
        if(externalStorage!=null)
            deviceInfo += externalStorage.getInfo();
        return deviceInfo;
    }


}
