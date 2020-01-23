package com.transoft.appspp.ui.scanner;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.transoft.appspp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScannerActivity extends Activity {

    private CodeScanner codeScanner;

    @BindView(R.id.resultsOfQr)
    public TextView tvResult;

    @BindView(R.id.scannerView)
    public CodeScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        ButterKnife.bind(this);
        initialize();
        setupWidgets();
    }

    private void initialize() {
        codeScanner = new CodeScanner(this, scannerView);
    }

    private void setupWidgets() {
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(result.getText());
                        if (result.getText() != null)
                            separate(result.getText());
                    }
                });

            }
        });
    }

    @OnClick(R.id.scannerView)
    public void openScanner() {
        codeScanner.startPreview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestForCamera();
    }

    public void requestForCamera() {
        Dexter.withActivity(this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                codeScanner.startPreview();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Toast.makeText(ScannerActivity.this, "Camera Permission is Required.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    public static void separate(String QRcode) {
        System.out.println("I am here");
        System.out.println(QRcode);
    }

}
