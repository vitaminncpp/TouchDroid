package com.akshayaap.touchdroid.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.util.Server;

import java.util.ArrayList;

public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.WifiViewHolder> {
    Context context;
    ArrayList<Server> wifiList;
    OnItemClickListener clickListener;

    public WifiListAdapter(Context context, ArrayList<Server> wifiList) {
        this.context = context;
        this.wifiList = wifiList;
    }

    @NonNull
    @Override
    public WifiListAdapter.WifiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater todoInflater = LayoutInflater.from(context);
        View wifiView = todoInflater.inflate(R.layout.wifi_server_list_layout, parent, false);
        return new WifiListAdapter.WifiViewHolder(wifiView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WifiViewHolder holder, int position) {
        holder.textView_wifiNameTitle.setText(wifiList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return wifiList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class WifiViewHolder extends RecyclerView.ViewHolder {
        TextView textView_wifiNameTitle;

        public WifiViewHolder(@NonNull View itemView, OnItemClickListener clickListener) {
            super(itemView);
            textView_wifiNameTitle = itemView.findViewById(R.id.textView_wifiNameTitle);

            itemView.setOnClickListener(view -> {
                if (clickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        clickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
