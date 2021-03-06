package com.transoft.appspp.di.module;

import com.transoft.appspp.api.ApiService;
import com.transoft.appspp.mvp.menu.MenuActivityModel;
import com.transoft.appspp.mvp.menu.MenuActivityMvp;
import com.transoft.appspp.mvp.menu.MenuActivityPresenter;
import com.transoft.appspp.mvp.pickup.PickupActivityModel;
import com.transoft.appspp.mvp.pickup.PickupActivityMvp;
import com.transoft.appspp.mvp.pickup.PickupActivityPresenter;
import com.transoft.appspp.mvp.pickup.PickupRepository;
import com.transoft.appspp.mvp.pickup.PickupRepositoryImpl;
import com.transoft.appspp.mvp.sales.SalesActivityModel;
import com.transoft.appspp.mvp.sales.SalesActivityMvp;
import com.transoft.appspp.mvp.sales.SalesActivityPresenter;
import com.transoft.appspp.mvp.sales.SalesRepository;
import com.transoft.appspp.mvp.sales.SalesRepositoryImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {

    @Provides
    public MenuActivityMvp.Presenter providesMenuActivityPresenter(MenuActivityMvp.Model model) {
        return new MenuActivityPresenter(model);
    }

    @Provides
    public MenuActivityMvp.Model providesMenuActivityModel() {
        return new MenuActivityModel();
    }

    @Provides
    public PickupActivityMvp.Presenter providesPickupActivityPresenter(PickupActivityMvp.Model model) {
        return new PickupActivityPresenter(model);
    }

    @Provides
    public PickupActivityMvp.Model providesPickupActivityModel(PickupRepository repository) {
        return new PickupActivityModel(repository);
    }

    @Provides
    public PickupRepository providePickupRepository(ApiService apiService) {
        return new PickupRepositoryImpl(apiService);
    }

    @Provides
    public SalesActivityMvp.Model providesSalesActvityModel(SalesRepository repository) {
        return new SalesActivityModel(repository);
    }

    @Provides
    public SalesActivityMvp.Presenter providesSalesActivityPresenter(SalesActivityMvp.Model model) {
        return new SalesActivityPresenter(model);
    }

    @Provides
    public SalesRepository provideSalesRepository(ApiService apiService) {
        return new SalesRepositoryImpl(apiService);
    }
}
