package com.transoft.appspp.mvp.pickup;

import com.transoft.appspp.model.Pickup;

import java.util.List;

import io.reactivex.Observable;

public interface PickupActivityMvp {

    interface Model {
        Observable<List<Pickup>> findAllPickups();
    }

    interface View {

        void showSnackBar(String message);

        void showData(List<Pickup> pickups);

        void showError(String message);


        void showProgress();

        void hideProgress();
    }

    interface Presenter {
       void setView(PickupActivityMvp.View view);
       void loadData();
       void save(Pickup pickup);
       void unsubscribe();
    }
}
