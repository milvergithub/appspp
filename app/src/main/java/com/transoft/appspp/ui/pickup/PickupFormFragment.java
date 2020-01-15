package com.transoft.appspp.ui.pickup;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.View;
import com.transoft.appspp.R;

public class PickupFormFragment extends BottomSheetDialogFragment {

    private BottomSheetBehavior sheetBehavior;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_pickupform, null);

        dialog.setContentView(view);
        sheetBehavior = BottomSheetBehavior.from((View)view.getParent());

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}
