package com.tca.daggersample.daggersample.models;

import javax.inject.Inject;

/**
 * Created by TCA on 19-03-2017.
 */

public class SmartPhone {

    String name;

    public SmartPhone(String name) {
        this.name = name;
    }

    @Inject ExternalStorage externalStorage;

    @Inject Processor processor;

    public  String getDeviceInfo(){
        String deviceInfo;
        deviceInfo = name + " Details \n";

        if(externalStorage!=null)
            deviceInfo += externalStorage.getInfo();
        //deviceInfo += processor.getInfo();
        return deviceInfo;
    }


}
