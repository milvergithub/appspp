package com.transoft.appspp.di.module;

import com.transoft.appspp.adapter.PickupAdapter;
import com.transoft.appspp.adapter.SeatAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    @Provides
    public PickupAdapter getPickupAdapter() {
        return new PickupAdapter();
    }

    @Provides
    public SeatAdapter getSeatAdapter() {
        return new SeatAdapter();
    }
}
