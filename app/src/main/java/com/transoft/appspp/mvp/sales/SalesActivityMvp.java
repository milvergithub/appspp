package com.transoft.appspp.mvp.sales;

import com.transoft.appspp.model.Seat;

import java.util.List;

import io.reactivex.Observable;

public interface SalesActivityMvp {
    interface Model {
        Observable<List<Seat>> findAllSeats(Integer size);
    }
    interface View {
        void showSnackBar(String message);
        void showData(List<Seat> seats);
        void showProgress();
        void hideProgress();
    }
    interface Presenter {
        void loadData();
        void setView(SalesActivityMvp.View view);
    }
}
