package com.transoft.appspp.ui.pickup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.View;
import android.widget.Button;
import com.transoft.appspp.R;
import com.transoft.appspp.model.Pickup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PickupFormFragment extends BottomSheetDialogFragment {

    private OnPickupFormListener listener;
    private BottomSheetBehavior sheetBehavior;

    @BindView(R.id.btn_pu_save)
    public Button saveButton;

    @BindView(R.id.btn_pu_cancel)
    public Button cancelButton;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_pickupform, null);
        dialog.setContentView(view);
        sheetBehavior = BottomSheetBehavior.from((View)view.getParent());
        sheetBehavior.setPeekHeight(200);
        ButterKnife.bind(this, view);
        return dialog;
    }

    @OnClick(R.id.btn_pu_save)
    public void onSaveButton() {
        listener.savePickupForm(null);
    }

    @OnClick(R.id.btn_pu_cancel)
    public void onCancelButton() {
        listener.cancelPickupForm();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPickupFormListener) {
            listener = (OnPickupFormListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement PickupFormFragment.OnPickupFormListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public interface OnPickupFormListener {
        void savePickupForm(Pickup pickup);
        void cancelPickupForm();
    }
}
