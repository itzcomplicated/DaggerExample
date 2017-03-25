package com.tca.daggersample.daggersample.models;

import javax.inject.Inject;

/**
 * Created by TCA on 19-03-2017.
 */

public class Processor {

    @Inject InternalStorage internalStorage;

    int lenght=64;


    public String getInfo(){
        String info=  lenght + "bit processor \n";
        if(internalStorage !=null)
            info += internalStorage.getInfo();
        return info;
    }
}
