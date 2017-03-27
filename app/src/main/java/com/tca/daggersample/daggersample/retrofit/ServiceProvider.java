package com.tca.daggersample.daggersample.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TCA on 27-03-2017.
 */

public class ServiceProvider {

    public ServiceProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GitHubService.class);
    }

    GitHubService service;

    public GitHubService getService() {
        return service;
    }
}
