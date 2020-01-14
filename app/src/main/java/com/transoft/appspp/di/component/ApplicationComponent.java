package com.transoft.appspp.di.component;

import com.transoft.appspp.MainActivity;
import com.transoft.appspp.di.module.AdapterModule;
import com.transoft.appspp.di.module.ApplicationModule;
import com.transoft.appspp.di.module.MvpModule;
import com.transoft.appspp.di.module.RetrofitModule;
import com.transoft.appspp.ui.menu.MenuActivity;
import com.transoft.appspp.ui.pickup.PickupActivity;
import com.transoft.appspp.ui.sppmenu.SppMenuActivity;

import dagger.Component;

@Component(modules = {ApplicationModule.class, MvpModule.class, AdapterModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MenuActivity menuActivity);

    void inject(SppMenuActivity sppMenuActivity);

    void inject(PickupActivity pickupActivity);
}
