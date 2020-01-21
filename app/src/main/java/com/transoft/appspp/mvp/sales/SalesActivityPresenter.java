package com.transoft.appspp.mvp.sales;

import com.transoft.appspp.model.Seat;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SalesActivityPresenter implements SalesActivityMvp.Presenter {

    private SalesActivityMvp.Model model;
    private SalesActivityMvp.View view;
    private Disposable subscription;

    public SalesActivityPresenter(SalesActivityMvp.Model model) {
        this.model = model;
    }

    public void setView(SalesActivityMvp.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        subscription = model.findAllSeats(100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Seat>>() {
                    @Override
                    public void onNext(List<Seat> seats) {
                        view.showData(seats);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        view.showSnackBar("Error al obtener datos");
                        view.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        view.hideProgress();
                    }
                });
    }
}
