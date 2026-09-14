package com.akshayaap.touchdroid.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayaap.touchdroid.R
import com.akshayaap.touchdroid.abstractfactory.GlobalFactory
import com.akshayaap.touchdroid.network.UDPReceiver
import com.akshayaap.touchdroid.ui.adapters.WifiListAdapter
import com.akshayaap.touchdroid.util.Server
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.IOException
import java.net.InetAddress
import java.net.UnknownHostException

class Network : Fragment() {
    private var wifiLogo: ImageView? = null
    private var serverListView: RecyclerView? = null
    private var adapter: WifiListAdapter? = null
    private var networkList: ArrayList<Server> = ArrayList()
    private var connection: ConnectionThread? = null

    init {
        GlobalFactory.getFactory().createEchoReceiver()
        connection = ConnectionThread()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_network, container, false)
        wifiLogo = view.findViewById(R.id.imageView_wifiLogo)
        serverListView = view.findViewById(R.id.serverListView)
        val context = requireContext()
        val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in_fade_out)
        wifiLogo?.startAnimation(animation)
        serverListView?.visibility = View.VISIBLE

        networkList = ArrayList()
        val wifiAdapter = WifiListAdapter(context, networkList)
        adapter = wifiAdapter
        serverListView?.adapter = wifiAdapter
        serverListView?.layoutManager = LinearLayoutManager(context)

        wifiAdapter.setOnItemClickListener { position ->
            connection?.terminate()
            val nav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
            Log.d("debug", nav.toString())
            nav?.selectedItemId = R.id.nav_touchpad
            networkList.getOrNull(position)?.ip?.let { ip ->
                GlobalFactory.getFactory().createMessageSender(ip)
            }
            GlobalFactory.getFactory().terminateEchoReceiver()
        }

        if (connection?.isAlive != true) {
            connection?.start()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        connection?.terminate()
    }

    inner class ConnectionThread : Thread() {
        @Volatile
        var isRunning: Boolean = true
        val data = ByteArray(4)
        private var ipAddress: InetAddress? = null
        private val echo: UDPReceiver? = GlobalFactory.getFactory().echoReceiver

        init {
            echo?.setOnReceivedCallback {
                activity?.runOnUiThread {
                    adapter?.notifyDataSetChanged()
                }
            }
        }

        override fun run() {
            while (isRunning) {
                synchronized(this) {
                    try {
                        echo?.receive(data)
                        Log.i("network", "${data[0]}.${data[1]}.${data[2]}.${data[3]}")
                    } catch (e: IOException) {
                        GlobalFactory.getFactory().logger.log("networkerr", "Error Receiving Echo: ${e.message}")
                    }
                    ipAddress = echo?.packet?.address
                    val ip = ipAddress
                    if (ip != null) {
                        try {
                            val hostAddress = ip.hostAddress ?: ""
                            GlobalFactory.getFactory().addServer(Server(hostAddress, ip.hostName))
                        } catch (e: UnknownHostException) {
                            GlobalFactory.getFactory().logger.log("networkerr", "Host Error: ${e.message}")
                        }
                        networkList.clear()
                        networkList.addAll(GlobalFactory.getFactory().getServers())
                    }
                }
            }
        }

        fun terminate() {
            isRunning = false
            interrupt()
        }
    }
}
