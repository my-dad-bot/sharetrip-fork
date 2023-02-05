package net.sharetrip.flight.utils

import android.content.Context
import net.sharetrip.tracker.FlightTrackerActivity

class FlightTrackerUtils {

    fun openFlightTracker(context: Context) {
        FlightTrackerActivity.openFlightTrackerActivity(context, FlightTrackerActivity::class.java)
    }
}
