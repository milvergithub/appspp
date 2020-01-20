package com.transoft.appspp.api;

import com.transoft.appspp.model.Pickup;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("pickups")
    Observable<List<Pickup>> finAllPickup();

    @POST("pickups")
    Observable<Pickup> savePickup(@Body Pickup pickup);
}
