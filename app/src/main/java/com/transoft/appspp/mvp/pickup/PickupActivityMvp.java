package com.transoft.appspp.mvp.pickup;

import com.transoft.appspp.model.Pickup;

import java.util.List;

import io.reactivex.Observable;

public interface PickupActivityMvp {

    interface Model {
        Observable<List<Pickup>> findAllPickups();
        Observable<Pickup> save(Pickup pickup);
    }

    interface View {

        void showSnackBar(String message);
        void showData(List<Pickup> pickups);
        void showProgress();
        void hideProgress();
        void onSave();
        void onCancel();
        void setName(String name);
        void setAddress(String address);
        void setAmount(String amount);
        void setCi(String ci);
        void setPhone(String phone);
        String getName();
        String getAddress();
        String getAmount();
        String getCi();
        String getPhone();
    }

    interface Presenter {
       void setView(PickupActivityMvp.View view);
       void setPickupDetail(Pickup pickup);
       void loadData();
       void save();
       void unsubscribe();
    }
}
