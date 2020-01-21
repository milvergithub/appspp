package com.transoft.appspp.mvp.sales;

import com.transoft.appspp.model.Seat;

import java.util.List;

import io.reactivex.Observable;

public interface SalesRepository {
    Observable<List<Seat>> findAll(Integer size);
}
