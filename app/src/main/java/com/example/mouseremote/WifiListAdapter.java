package com.example.mouseremote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshayaap.mouseremote.R;

import java.util.ArrayList;

public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.WifiViewHolder> {
    Context context;
    ArrayList<String> wifiList;
    OnItemClickListener clickListener;

    public WifiListAdapter(Context context, ArrayList<String> wifiList) {
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

    }

    @Override
    public int getItemCount() {
        return wifiList.size();
    }

    public static class WifiViewHolder extends RecyclerView.ViewHolder {
        public WifiViewHolder(@NonNull View itemView, OnItemClickListener clickListener) {
            super(itemView);

        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
