package com.transoft.appspp.ui.menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.transoft.appspp.R;
import com.transoft.appspp.di.SppApplication;
import com.transoft.appspp.mvp.menu.MenuActivityMvp;
import com.transoft.appspp.ui.sppmenu.SppMenuActivity;
import com.transoft.appspp.util.AndroidUtil;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MenuActivity extends Activity implements MenuActivityMvp.View {

    @BindView(R.id.btn_qr_scanner)
    public Button btnScanner;

    @BindView(R.id.btn_spp)
    public Button btnSpp;

    @Inject
    MenuActivityMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
    }

    @OnClick(R.id.btn_spp)
    public void onOpenSpp() {
        startActivity(new Intent(getApplicationContext(), SppMenuActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @SuppressLint("ShowToast")
    @Override
    public void showSnackBar(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }
}
