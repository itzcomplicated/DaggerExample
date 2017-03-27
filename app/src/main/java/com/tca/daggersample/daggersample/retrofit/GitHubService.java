package com.tca.daggersample.daggersample.retrofit;

import com.tca.daggersample.daggersample.retrofit.models.Events;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TCA on 27-03-2017.
 */

public interface GitHubService {
        @GET("events/")
        Call<List<Events>> listRepos();
}
