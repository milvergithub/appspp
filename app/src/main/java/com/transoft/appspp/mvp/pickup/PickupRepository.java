package com.transoft.appspp.mvp.pickup;

import com.transoft.appspp.model.Pickup;

import java.util.List;

import io.reactivex.Observable;

public interface PickupRepository {

    Observable<List<Pickup>> findAll();
}
