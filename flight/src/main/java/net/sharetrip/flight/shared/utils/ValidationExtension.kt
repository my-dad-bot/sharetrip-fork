package net.sharetrip.flight.shared.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DecimalFormat

fun String?.isNameValid(): Boolean {
    try {
        if (this == null || this.isEmpty()) {
            return false
        }
        return RegexValidation.validRegex(this, NAME_REGEX)
    } catch (e: Exception) {
        return false
    }
}

fun String?.isPassportNumberValid(): Boolean {
    if (this == null || this.isEmpty())
        return false
    return RegexValidation.validRegex(this, PASSPORT_REGEX)
}

fun String?.isPhoneNumberValid(): Boolean {
    return !isNullOrEmpty() && this.matches(PHONE_VALIDATION_REGEX.toRegex()) && this.length >= 11
}

fun String?.isEmailValid(): Boolean {
    return !isNullOrEmpty() && this.matches(EMAIL_REGEX.toRegex())
}

fun String?.getUserTitleForFlight(dateOfBirth: String, flightDate: String): String {
    return if (DateUtil.getAgeForFlight(dateOfBirth, flightDate) <= 11 && this.equals("Male")) {
        "MSTR"
    } else if (DateUtil.getAgeForFlight(dateOfBirth, flightDate) > 11 && this.equals("Male")) {
        "MR"
    } else if (DateUtil.getAgeForFlight(dateOfBirth, flightDate) <= 11 && this.equals("Female")) {
        "MISS"
    } else if (DateUtil.getAgeForFlight(dateOfBirth, flightDate) > 11 && this.equals("Female")) {
        "MS"
    } else {
        ""
    }
}

@BindingAdapter("formattedDate")
fun TextView.formatDateString(text: String?) {
    text?.let {
        this.text = "- Last Update: " + DateUtil.parseDisplayDateFormatFromLongDateString(text)
    }
}

fun formatToTwoDigit(input: Any): String {
    return String.format("%02d", input)
}

fun Double.twoDigitDecimal(): Double {
    val df = DecimalFormat("#.##")
    return try {
        df.format(this).toDouble()
    } catch (e: Exception) {
        this
    }
}

fun String?.isPassportExpiryDateValid(): Boolean {
    return try {
        !(this == null || this.isEmpty())

    } catch (e: Exception) {
        false
    }
}
