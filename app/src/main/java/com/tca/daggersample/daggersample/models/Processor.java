package com.tca.daggersample.daggersample.models;

import javax.inject.Inject;

/**
 * Created by TCA on 19-03-2017.
 */

public class Processor {

    InternalStorage internalStorage;

    int lenght=64;

    @Inject
    public Processor(InternalStorage internalStorage) {
        this.internalStorage=internalStorage;
    }

    public String getInfo(){
        String info=  lenght + "bit processor \n";
        if(internalStorage !=null)
            info += getInfo();
        return info;
    }
}
