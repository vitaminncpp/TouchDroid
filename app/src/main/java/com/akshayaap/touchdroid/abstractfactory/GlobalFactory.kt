package com.akshayaap.touchdroid.abstractfactory

import com.akshayaap.touchdroid.config.Config
import com.akshayaap.touchdroid.debug.DebugDatabase
import com.akshayaap.touchdroid.io.KeyMap
import com.akshayaap.touchdroid.network.UDPReceiver
import com.akshayaap.touchdroid.network.UDPSender
import com.akshayaap.touchdroid.util.Server
import com.akshayaap.touchdroid.util.logger.LoggMessage
import com.akshayaap.touchdroid.util.logger.Logger
import java.net.InetAddress
import java.net.SocketException

class GlobalFactory private constructor() {

    // Factory members
    var messageSender: UDPSender? = null
        private set

    var echoReceiver: UDPReceiver? = null
        private set

    val keyMap: KeyMap = KeyMap()
    private val servers: HashMap<String, Server> = HashMap()

    // utils
    val dd: DebugDatabase = DebugDatabase()
    val logger: Logger = object : Logger {
        override fun log(message: LoggMessage) {
            dd.addMessage(message)
        }

        override fun log(tag: String, message: String) {
            val msg = LoggMessage(tag, message)
            dd.addMessage(msg)
        }
    }

    fun createEchoReceiver(): UDPReceiver? {
        try {
            this.echoReceiver = UDPReceiver(Config.ECHO_PORT)
        } catch (e: SocketException) {
            val message = LoggMessage("networkerr", "Network Error: ${e.message}", Thread.currentThread().stackTrace)
            logger.log(message)
        }
        return this.echoReceiver
    }

    fun createMessageSender(address: InetAddress): UDPSender? {
        this.messageSender?.close()
        try {
            this.messageSender = UDPSender(address, Config.SERVER_PORT)
        } catch (e: SocketException) {
            logger.log("networkerr", "Failed to Create messageSender: ${e.message}")
        }
        return this.messageSender
    }

    fun terminateEchoReceiver() {
        this.echoReceiver?.close()
    }

    fun addServer(server: Server) {
        val hostAddress = server.ip.hostAddress ?: return
        this.servers[hostAddress] = server
    }

    fun getServers(): Collection<Server> {
        return this.servers.values
    }

    companion object {
        private val instance: GlobalFactory = GlobalFactory()

        @JvmStatic
        fun getFactory(): GlobalFactory {
            return instance
        }
    }
}
