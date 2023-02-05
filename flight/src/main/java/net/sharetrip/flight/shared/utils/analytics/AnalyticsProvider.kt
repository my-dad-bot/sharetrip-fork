package net.sharetrip.flight.shared.utils.analytics

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

/*
todo ->  Please check if Analytics is needed or creates problem for library publication
 */

object AnalyticsProvider {

    private var firebaseAnalytics: FirebaseAnalytics? = null

    fun getFirebaseAnalytics(): FirebaseAnalytics {
        if (firebaseAnalytics == null) firebaseAnalytics = Firebase.analytics
        return firebaseAnalytics!!
    }

    fun flightEventManager(firebaseAnalytics: FirebaseAnalytics) =
        FlightEventManager.Builder().setFirebaseAnalytics(firebaseAnalytics).build()

}