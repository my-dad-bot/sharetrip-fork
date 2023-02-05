package net.sharetrip.shared.utils

import android.text.SpannableStringBuilder
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import net.sharetrip.shared.R
import java.text.NumberFormat
import java.util.*

fun Fragment.hideToolbar(toolbarId: Int) {
    (activity as AppCompatActivity).findViewById<Toolbar>(toolbarId).visibility = View.GONE
}

fun Fragment.showToolbar(toolbarId: Int) {
    (activity as AppCompatActivity).findViewById<Toolbar>(toolbarId).visibility = View.VISIBLE
}

fun Fragment.hideAppbar(toolbarId: Int) {
    (activity as AppCompatActivity).findViewById<AppBarLayout>(toolbarId).visibility = View.GONE
}

fun Fragment.showAppbar(toolbarId: Int) {
    (activity as AppCompatActivity).findViewById<AppBarLayout>(toolbarId).visibility = View.VISIBLE
}


fun Fragment.setTitleAndSubtitle(title: String = "", subTitle: String = "") {
    (activity as AppCompatActivity).supportActionBar?.apply {
        this.title = title
        this.subtitle = subTitle
    }
}

fun Fragment.setTitleAndSubtitle(
    title: SpannableStringBuilder = SpannableStringBuilder(),
    subTitle: StringBuilder = StringBuilder()
) {
    (activity as AppCompatActivity).supportActionBar?.apply {
        this.title = title
        this.subtitle = subTitle
    }
}

fun Fragment.setTripCoin(coin: String, textViewId: Int) {
    val points = coin.filter { it in '0'..'9' }
    if (points.isNotEmpty())
        (activity as AppCompatActivity).findViewById<AppCompatTextView>(textViewId).text =
            NumberFormat.getNumberInstance(Locale.US).format(points?.toInt())
}

fun Fragment.hideTripCoin(textViewId: Int) {
    (activity as AppCompatActivity).findViewById<AppCompatTextView>(textViewId).visibility =
        View.GONE
}

fun Fragment.showTripCoin(textViewId: Int) {
    (activity as AppCompatActivity).findViewById<AppCompatTextView>(textViewId).visibility =
        View.VISIBLE
}

