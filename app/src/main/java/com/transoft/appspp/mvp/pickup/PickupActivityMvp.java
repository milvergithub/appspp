package com.transoft.appspp.mvp.pickup;

public interface PickupActivityMvp {

    interface Model {
    }

    interface View {
        void showSnackBar(String message);
    }

    interface Presenter {
       void setView(PickupActivityMvp.View view);
    }
}
