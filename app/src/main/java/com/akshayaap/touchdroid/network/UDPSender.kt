package com.akshayaap.touchdroid.network

import com.akshayaap.touchdroid.util.TaskCompleteCallback
import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketException
import kotlin.concurrent.thread

class UDPSender {
    private var socket: DatagramSocket
    var packet: DatagramPacket
        private set

    @Volatile
    private var onErr = false

    @Volatile
    private var ex: IOException? = null

    private var onSent: TaskCompleteCallback? = null

    @Throws(SocketException::class)
    constructor(ip: InetAddress, port: Int) {
        socket = DatagramSocket(port)
        val buffer = ByteArray(1024)
        packet = DatagramPacket(buffer, buffer.size, ip, port)
        onSent = TaskCompleteCallback { }
    }

    @Throws(SocketException::class)
    constructor() {
        socket = DatagramSocket()
        packet = DatagramPacket(ByteArray(1), 0)
    }

    @Throws(IOException::class)
    fun send(data: ByteArray) {
        packet.data = data
        packet.length = data.size
        thread {
            try {
                socket.send(packet)
                onSent?.complete()
            } catch (e: IOException) {
                onErr = true
                this.ex = e
            }
        }
        if (onErr) {
            onErr = false
            ex?.let { throw it }
        }
    }

    fun setOnSentCallback(onSent: TaskCompleteCallback) {
        this.onSent = onSent
    }

    fun close() {
        if (!socket.isClosed) {
            socket.close()
        }
    }
}
