package com.transoft.appspp.mvp.pickup;

import com.transoft.appspp.api.ApiService;
import com.transoft.appspp.model.Pickup;

import java.util.List;

import io.reactivex.Observable;

public class PickupRepositoryImpl implements PickupRepository {

    private ApiService apiService;

    public PickupRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Pickup>> findAll() {
        return apiService.finAllPickup();
    }
}
