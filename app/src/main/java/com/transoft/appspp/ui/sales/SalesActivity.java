package com.transoft.appspp.ui.sales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.transoft.appspp.R;
import com.transoft.appspp.adapter.SeatAdapter;
import com.transoft.appspp.di.SppApplication;
import com.transoft.appspp.model.Seat;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SalesActivity extends AppCompatActivity implements SeatAdapter.ClickListener {

    @BindView(R.id.recycler_view_seats)
    public RecyclerView recyclerView;

    @Inject
    public SeatAdapter seatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        seatAdapter.setClickListener(this);
        recyclerView.setAdapter(seatAdapter);
    }

    @Override
    public void onClickListener(Seat seat) {

    }
}
