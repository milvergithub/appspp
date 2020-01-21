package com.transoft.appspp.mvp.sales;

import com.transoft.appspp.api.ApiService;
import com.transoft.appspp.model.Seat;

import java.util.List;

import io.reactivex.Observable;

public class SalesRepositoryImpl implements SalesRepository {

    private ApiService apiService;

    public SalesRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Seat>> findAll(Integer size) {
        return apiService.finAllSeats(size);
    }
}
