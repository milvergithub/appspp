package com.transoft.appspp.mvp.pickup;

public class PickupActivityPresenter implements PickupActivityMvp.Presenter {

    private PickupActivityMvp.View view;
    private PickupActivityMvp.Model model;

    public PickupActivityPresenter(PickupActivityMvp.Model model) {
        this.model = model;
    }

    @Override
    public void setView(PickupActivityMvp.View view) {
        this.view = view;
    }
}
