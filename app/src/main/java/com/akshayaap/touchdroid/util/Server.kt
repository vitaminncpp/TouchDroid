package com.akshayaap.touchdroid.util

import java.net.InetAddress
import java.net.UnknownHostException

data class Server(
    val ip: InetAddress,
    val name: String
) {
    @Throws(UnknownHostException::class)
    constructor(ip: String, name: String) : this(InetAddress.getByName(ip), name)

    override fun toString(): String {
        return "{\"ip\":\"${ip.hostAddress}\", \"name\":\"$name\"}"
    }
}
