package com.akshayaap.touchdroid.network

import com.akshayaap.touchdroid.util.TaskCompleteCallback
import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.SocketException
import kotlin.concurrent.thread

class UDPReceiver(port: Int) {

    private val socket: DatagramSocket = DatagramSocket(port)
    var packet: DatagramPacket = DatagramPacket(ByteArray(4), 4)
        private set

    @Volatile
    private var onErr = false

    @Volatile
    private var ex: IOException? = null

    private var onReceived: TaskCompleteCallback = TaskCompleteCallback { }
    var worker: Thread? = null
    var isRunning = true

    init {
        packet.port = port
    }

    @Throws(IOException::class)
    fun receive(buff: ByteArray) {
        packet.length = buff.size
        packet.data = buff

        worker = thread {
            try {
                socket.receive(packet)
                onReceived.complete()
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

    @Throws(IOException::class)
    fun receive(buff: ByteArray, onReceived: TaskCompleteCallback) {
        val temp = this.onReceived
        this.onReceived = onReceived
        receive(buff)
        this.onReceived = temp
    }

    fun setOnReceivedCallback(onReceived: TaskCompleteCallback) {
        this.onReceived = onReceived
    }

    fun close() {
        worker?.interrupt()
        if (!socket.isClosed) {
            socket.close()
        }
    }
}
