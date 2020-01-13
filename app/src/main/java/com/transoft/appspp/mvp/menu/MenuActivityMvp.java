package com.transoft.appspp.mvp.menu;

public interface MenuActivityMvp {

    interface Model {
    }

    interface View {
        void showSnackBar(String message);
    }

    interface Presenter {
        void setView(MenuActivityMvp.View view);
    }
}
