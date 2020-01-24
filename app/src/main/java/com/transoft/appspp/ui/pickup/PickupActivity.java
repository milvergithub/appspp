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
import android.widget.EditText;
import android.widget.ProgressBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
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
import butterknife.OnClick;

public class PickupActivity extends AppCompatActivity implements PickupActivityMvp.View, PickupAdapter.ClickListener {

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

    private BottomSheetBehavior sheetBehavior;
    private BottomSheetBehavior detailSheetBehavior;

    @BindView(R.id.form_pickup)
    View formPickup;

    @BindView(R.id.detail_pickup)
    View detailPickup;

    @BindView(R.id.rpc_ci)
    public EditText ci;

    @BindView(R.id.rpc_name)
    public EditText name;

    @BindView(R.id.rpc_nit)
    public EditText nit;

    @BindView(R.id.rpc_phone)
    public EditText phone;

    @BindView(R.id.rpc_address)
    public EditText address;

    @BindView(R.id.rpc_amount)
    public EditText amount;

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
        sheetBehavior = BottomSheetBehavior.from(formPickup);
        sheetBehavior.setPeekHeight(0);
        detailSheetBehavior = BottomSheetBehavior.from(detailPickup);
        detailSheetBehavior.setPeekHeight(0);
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

    @OnClick(R.id.add_pick_up)
    public void onAddPickup() {
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    @OnClick(R.id.btn_pu_save)
    public void onSave() {
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        presenter.save();
    }

    @Override
    @OnClick(R.id.btn_pu_cancel)
    public void onCancel() {
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onClickListener(Pickup pickup) {
        detailSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        presenter.setPickupDetail(pickup);
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
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }

    @Override
    public void setAddress(String address) {
        this.address.setText(address);
    }

    @Override
    public void setAmount(String amount) {
        this.amount.setText(amount);
    }

    @Override
    public void setCi(String ci) {
        this.ci.setText(ci);
    }

    @Override
    public void setPhone(String phone) {
        this.phone.setText(phone);
    }

    @Override
    public String getName() {
        return this.name.getText().toString();
    }

    @Override
    public String getAddress() {
        return this.address.getText().toString();
    }

    @Override
    public String getAmount() {
        return this.amount.getText().toString();
    }

    @Override
    public String getCi() {
        return this.ci.getText().toString();
    }

    @Override
    public String getPhone() {
        return this.phone.getText().toString();
    }
}
