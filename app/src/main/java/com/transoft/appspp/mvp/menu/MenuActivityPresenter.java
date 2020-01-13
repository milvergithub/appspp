package com.transoft.appspp.mvp.menu;

public class MenuActivityPresenter implements MenuActivityMvp.Presenter {

    private MenuActivityMvp.View view;
    private MenuActivityMvp.Model model;

    public MenuActivityPresenter(MenuActivityMvp.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MenuActivityMvp.View view) {
        this.view = view;
    }
}
