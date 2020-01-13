package com.transoft.appspp.di;

import android.app.Application;

import com.transoft.appspp.di.module.AdapterModule;
import com.transoft.appspp.di.module.ApplicationModule;
import com.transoft.appspp.di.component.ApplicationComponent;
import com.transoft.appspp.di.component.DaggerApplicationComponent;
import com.transoft.appspp.di.module.MvpModule;

public class SppApplication extends Application {

    private ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .mvpModule(new MvpModule())
                .adapterModule(new AdapterModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
