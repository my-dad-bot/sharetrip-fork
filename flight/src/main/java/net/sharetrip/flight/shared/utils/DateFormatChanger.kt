package net.sharetrip.flight.shared.utils

import net.sharetrip.flight.shared.utils.DateUtil.API_DATE_PATTERN
import net.sharetrip.flight.shared.utils.DateUtil.DISPLAY_DATE_PATTERN
import net.sharetrip.flight.shared.utils.DateUtil.DISPLAY_MONTH_PATTERN
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.dateChangeToDDMMYYYY(): String {
    val finalDate: String
    val input = SimpleDateFormat("yyyy-MM-dd")
    val output = SimpleDateFormat("dd-MM-yyyy")

    finalDate = try {
        val oneWayTripDate = input.parse(this)
        output.format(oneWayTripDate)
    } catch (e: Exception) {
        ""
    }
    return finalDate
}

fun String.dateChangeToMMMDDYY(): String {
    var finalDate: String? = null
    val input = SimpleDateFormat("yyyy-MM-dd")
    val output = SimpleDateFormat("EEE, MMMM dd, yyyy", Locale.US)

    finalDate = try {
        val oneWayTripDate = input.parse(this) // parse input
        output.format(oneWayTripDate)
    } catch (e: ParseException) {
        e.printStackTrace()
        this
    }
    return finalDate!!
}

fun String.dateChangeToDDMMYY(): String? {
    var finalDate: String
    val input = SimpleDateFormat("yyyy-MM-dd")
    val output = SimpleDateFormat("MMM dd, yyyy")

    finalDate = try {
        val oneWayTripDate = input.parse(this) // parse input
        output.format(oneWayTripDate)
    } catch (e: ParseException) {
        e.printStackTrace()
        this
    }
    return finalDate
}

fun String.dateChangeToDDMMYYHistory(): String? {
    val finalDate: String
    val input = SimpleDateFormat("MM/dd/yyyy")
    val output = SimpleDateFormat("MMM dd, yyyy")

    finalDate = try {
        val oneWayTripDate = input.parse(this) // parse input
        output.format(oneWayTripDate)
    } catch (e: ParseException) {
        this
    }
    return finalDate
}

fun String.parseDateForDisplayFromApi(): String {
    if (this.isNullOrEmpty()) return this
    val mApiDateFormat = SimpleDateFormat(API_DATE_PATTERN)
    val mDisplayDateFormat = SimpleDateFormat(DISPLAY_DATE_PATTERN)
    val mDate = mApiDateFormat.parse(this)
    return mDisplayDateFormat.format(mDate)
}

fun String.getProperFlightStartDate(bookTodayFlight: Boolean): Long {
    val bookingDate: Long = if (bookTodayFlight) 0 else 1
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val currentDateTime = Date()
    val timeThresholdString = formatter.format(currentDateTime) + " " + this
    val timeDateThresholdFormatter = SimpleDateFormat("dd/MM/yyyy HH:mm")
    val thresholdDateTime = timeDateThresholdFormatter.parse(timeThresholdString)
    return if (currentDateTime.after(thresholdDateTime)) {
        bookingDate + 1
    } else {
        bookingDate
    }
}

fun String.isValidCancellationFightTime(): Boolean {
    return try {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        val currentDateTime = Date()
        val cancellationTime = formatter.parse(this)
        currentDateTime.before(cancellationTime)
    } catch (e: Exception) {
        true
    }
}

val LocalDate.yearMonth: YearMonth
    get() = YearMonth.of(year, month)