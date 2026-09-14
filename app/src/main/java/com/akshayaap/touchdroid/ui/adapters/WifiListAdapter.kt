package com.akshayaap.touchdroid.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshayaap.touchdroid.R
import com.akshayaap.touchdroid.util.Server

class WifiListAdapter(
    private val context: Context,
    private val wifiList: ArrayList<Server>
) : RecyclerView.Adapter<WifiListAdapter.WifiViewHolder>() {

    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WifiViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.wifi_server_list_layout, parent, false)
        return WifiViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: WifiViewHolder, position: Int) {
        holder.textViewWifiNameTitle.text = wifiList[position].name
    }

    override fun getItemCount(): Int = wifiList.size

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class WifiViewHolder(
        itemView: View,
        clickListener: OnItemClickListener?
    ) : RecyclerView.ViewHolder(itemView) {
        val textViewWifiNameTitle: TextView = itemView.findViewById(R.id.textView_wifiNameTitle)

        init {
            itemView.setOnClickListener {
                if (clickListener != null) {
                    val position = bindingAdapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        clickListener.onItemClick(position)
                    }
                }
            }
        }
    }
}
