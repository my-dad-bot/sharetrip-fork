package net.sharetrip.payment

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

private val moshi = Moshi.Builder().build()

fun String.convertPaymentUrlList() : List<net.sharetrip.payment.model.PaymentUrl>? {
    val type: Type = Types.newParameterizedType(
        MutableList::class.java,
        net.sharetrip.payment.model.PaymentUrl::class.java
    )
    val adapter = moshi.adapter<List<net.sharetrip.payment.model.PaymentUrl>>(type)
    return adapter.fromJson(this)
}

fun String.convertToUrlModel() : net.sharetrip.payment.model.BookingResponse? {
    val jsonAdapter = moshi.adapter(net.sharetrip.payment.model.BookingResponse::class.java)
    return jsonAdapter.fromJson(this)
}

const val ARG_PAYMENT_URL = "PaymentUrl"
const val SERVICE_TYPE = "serviceType"
const val SERVICE_TYPE_VISA = "SERVICE_TYPE_VISA"
const val SERVICE_TYPE_FLIGHT = "SERVICE_TYPE_FLIGHT"
const val SERVICE_TYPE_HOLIDAY = "SERVICE_TYPE_HOLIDAY"
const val SERVICE_TYPE_HOTEL = "SERVICE_TYPE_HOTEL"
const val ARG_BOOKING_DATE = "BOOKING_DATE"
const val ARG_RETURN_BOOKING_DATE = "RETURN_BOOKING_DATE"