package net.sharetrip.flight.utils

import java.security.MessageDigest

object Utils {

    fun getMD5HashString(input: String): String = MessageDigest
        .getInstance("MD5")
        .digest(input.toByteArray()).joinToString(separator = "") { String.format("%02X", it) }
}
