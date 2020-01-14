package com.transoft.appspp.mvp.pickup;

import com.transoft.appspp.model.Pickup;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PickupActivityPresenter implements PickupActivityMvp.Presenter {

    private PickupActivityMvp.View view;
    private PickupActivityMvp.Model model;
    private Disposable subscription;

    public PickupActivityPresenter(PickupActivityMvp.Model model) {
        this.model = model;
    }

    @Override
    public void setView(PickupActivityMvp.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        view.showProgress();
        subscription = model.findAllPickups()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Pickup>>() {
                    @Override
                    public void onNext(List<Pickup> pickups) {
                        view.showData(pickups);
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

    @Override
    public void unsubscribe() {
        if (this.subscription != null && this.subscription.isDisposed()) {
            subscription.dispose();
        }
    }
}
