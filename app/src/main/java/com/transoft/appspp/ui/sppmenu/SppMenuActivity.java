package com.transoft.appspp.ui.sppmenu;

import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.transoft.appspp.R;
import com.transoft.appspp.di.SppApplication;
import com.transoft.appspp.ui.pickup.PickupActivity;
import com.transoft.appspp.util.AndroidUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SppMenuActivity extends Activity {

    @BindView(R.id.card_pickup)
    public CardView cardPickUp;

    @BindView(R.id.card_delivery)
    public CardView cardDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spp_menu);
        initialize();
        setupWidgets();
    }

    private void initialize() {
        ButterKnife.bind(this);
        ((SppApplication) getApplication()).getComponent().inject(this);
    }

    private void setupWidgets() {
        Window window = getWindow();
        AndroidUtil.statusBarColorTransparentWithKeyboard(this, window);
        cardPickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PickupActivity.class));
            }
        });
        cardDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("CLICK DELIVERY...");
            }
        });
    }
}
