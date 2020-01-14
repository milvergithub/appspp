package com.transoft.appspp.api;

import com.transoft.appspp.model.Pickup;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("pickups")
    Observable<List<Pickup>> finAllPickup();
}
