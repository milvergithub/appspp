package com.transoft.appspp.adapter;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.transoft.appspp.R;
import com.transoft.appspp.model.Pickup;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PickupAdapter extends RecyclerView.Adapter<PickupAdapter.ViewHolder> {

    private List<Pickup> data;
    private PickupAdapter.ClickListener clickListener;

    @Inject
    public PickupAdapter() {
        this.data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pick_up_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Pickup pickup = data.get(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onClickListener(pickup);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View view;

        @BindView(R.id.pick_up_name)
        public TextView pickUpName;

        @BindView(R.id.pick_up_address)
        public TextView pickUpAddress;

        @BindView(R.id.pick_up_amount)
        public TextView pickUpAmount;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    public interface ClickListener {
        void onClickListener(Pickup pickup);
    }

    public void setData(List<Pickup> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
