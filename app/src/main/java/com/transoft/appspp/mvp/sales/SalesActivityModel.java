package com.transoft.appspp.mvp.sales;

import com.transoft.appspp.model.Seat;

import java.util.List;

import io.reactivex.Observable;

public class SalesActivityModel implements SalesActivityMvp.Model {

    private SalesRepository salesRepository;

    public SalesActivityModel(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public Observable<List<Seat>> findAllSeats(Integer size) {
        return salesRepository.findAll(size);
    }
}
