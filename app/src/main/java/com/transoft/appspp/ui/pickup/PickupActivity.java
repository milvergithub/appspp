package com.transoft.appspp.ui.pickup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.transoft.appspp.R;
import com.transoft.appspp.adapter.PickupAdapter;
import com.transoft.appspp.di.SppApplication;
import com.transoft.appspp.model.Pickup;
import com.transoft.appspp.mvp.pickup.PickupActivityMvp;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PickupActivity extends AppCompatActivity implements PickupActivityMvp.View, PickupAdapter.ClickListener {

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @BindView(R.id.add_pick_up)
    public FloatingActionButton actionButton;

    @Inject
    public PickupAdapter pickupAdapter;

    @Inject
    PickupActivityMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);
        initialize();
        setupWidgets();
    }

    private void initialize() {
        ButterKnife.bind(this);
        ((SppApplication) getApplication()).getComponent().inject(this);
    }

    private void setupWidgets() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccentDark));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        pickupAdapter.setClickListener(this);
        recyclerView.setAdapter(pickupAdapter);
    }

    @Override
    public void onClickListener(Pickup pickup) {
        System.out.println(pickup.getName());
    }

    @Override
    public void showSnackBar(String message) {

    }
}
