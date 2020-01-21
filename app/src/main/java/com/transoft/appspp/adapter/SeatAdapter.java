package com.transoft.appspp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.transoft.appspp.R;
import com.transoft.appspp.model.Seat;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.SeatHolder> {

    private List<Seat> data;
    private ClickListener clickListener;

    public SeatAdapter() {
        this.data = new ArrayList<>();
        Seat seat = new Seat();
        for (int i = 0; i < 40; i++) {
            seat.setId(i);
            seat.setNumber("01");
            seat.setStatus("FREE");
            this.data.add(seat);
        }
    }

    @NonNull
    @Override
    public SeatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeatHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.seat_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeatHolder holder, int position) {
        final Seat seat = data.get(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onClickListener(seat);
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

    class SeatHolder extends RecyclerView.ViewHolder {

        View view;

        SeatHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    public void setData(List<Seat> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClickListener(Seat seat);
    }
}
