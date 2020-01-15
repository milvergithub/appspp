package com.transoft.appspp.ui.pickup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.transoft.appspp.R;
import com.transoft.appspp.adapter.PickupAdapter;
import com.transoft.appspp.di.SppApplication;
import com.transoft.appspp.model.Pickup;
import com.transoft.appspp.mvp.pickup.PickupActivityMvp;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PickupActivity extends AppCompatActivity implements PickupActivityMvp.View,PickupAdapter.ClickListener, PickupFormFragment.OnPickupFormListener {

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @BindView(R.id.add_pick_up)
    public FloatingActionButton actionButton;

    @BindView(R.id.progressBar)
    public ProgressBar progressBar;

    @Inject
    public PickupAdapter pickupAdapter;

    @Inject
    PickupActivityMvp.Presenter presenter;

    PickupFormFragment formFragment = new PickupFormFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);
        initialize();
        setupWidgets();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
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
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formFragment.show(getSupportFragmentManager(), formFragment.getTag());
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        pickupAdapter.setClickListener(this);
        recyclerView.setAdapter(pickupAdapter);
    }

    @Override
    public void onClickListener(Pickup pickup) {
        this.showSnackBar(pickup.getName());
    }


    @Override
    public void showSnackBar(String message) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE).show();
    }

    @Override
    public void showData(List<Pickup> pickups) {
        pickupAdapter.setData(pickups);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void savePickupForm(Pickup pickup) {
        formFragment.dismiss();
        presenter.save(pickup);
    }

    @Override
    public void cancelPickupForm() {
        formFragment.dismiss();
    }
}
