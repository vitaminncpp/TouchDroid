package com.akshayaap.touchdroid.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.akshayaap.touchdroid.R
import com.akshayaap.touchdroid.abstractfactory.GlobalFactory
import com.akshayaap.touchdroid.io.Event
import com.akshayaap.touchdroid.network.UDPSender
import com.akshayaap.touchdroid.service.TouchPadService
import java.io.IOException
import java.nio.charset.StandardCharsets

class Touchpad : Fragment() {
    private var messageSender: UDPSender? = null
    private val touchPadService: TouchPadService = TouchPadService(this)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_touchpad, container, false)
        messageSender = GlobalFactory.getFactory().messageSender
        val layout = view.findViewById<ConstraintLayout>(R.id.touchpad)
        layout.setOnTouchListener(touchPadService.touchListener)
        return view
    }

    fun sendEvent(event: Event): Boolean {
        return try {
            val sender = messageSender ?: GlobalFactory.getFactory().messageSender
            sender?.send(event.toString().toByteArray(StandardCharsets.UTF_8))
            true
        } catch (e: IOException) {
            GlobalFactory.getFactory().logger.log("networkerr", "Error Sending Event data: ${e.message}")
            false
        }
    }
}
