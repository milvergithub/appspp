package com.transoft.appspp.mvp.pickup;

import com.transoft.appspp.model.Pickup;

import java.util.List;

import io.reactivex.Observable;

public class PickupActivityModel implements PickupActivityMvp.Model {

    private PickupRepository repository;

    public PickupActivityModel(PickupRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<Pickup>> findAllPickups() {
        return repository.findAll();
    }

    @Override
    public Observable<Pickup> save(Pickup pickup) {
        return repository.save(pickup);
    }
}
