package com.tca.daggersample.daggersample.models;

/**
 * Created by TCA on 19-03-2017.
 */

public class ExternalStorage {

    public ExternalStorage(int sizeInMB) {
        this.sizeInMB=sizeInMB;
    }

    int sizeInMB;

    public String getInfo(){
        return  sizeInMB + "MB External Storage \n";
    }

}
