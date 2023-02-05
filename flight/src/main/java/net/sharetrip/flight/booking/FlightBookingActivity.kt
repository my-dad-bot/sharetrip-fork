package net.sharetrip.flight.booking

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.FileUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.sharetrip.base.data.PrefKey
import com.sharetrip.base.data.SharedPrefsHelper
import net.sharetrip.flight.R
import net.sharetrip.flight.network.DataManager
import net.sharetrip.flight.utils.Utils
import java.security.MessageDigest

class FlightBookingActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var currentDestination: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_booking)
        setSupportActionBar(findViewById(R.id.toolbar))

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentDestination = destination.id
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (currentDestination == R.id.paymentSuccessFragment) {
            setResult(Activity.RESULT_OK)
            finish()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        var FLIGHT_PROMOTION_IMAGE = ""

        fun openFlightSearchService(context: Context, source: String, token: String? = null) {
            val appInfo: ApplicationInfo = context.packageManager.getApplicationInfo(
                context.packageName, PackageManager.GET_META_DATA
            )

            val sharedPrefsHelper: SharedPrefsHelper = DataManager.getSharedPref(context)

            if (token != null && token.trim().isNotEmpty()) {
                sharedPrefsHelper.put(PrefKey.ACCESS_TOKEN, token)
                sharedPrefsHelper.put(PrefKey.IS_LOGIN, true)
            }

            val bundle = appInfo.metaData
            val apiKey = bundle.getString("net.sharetrip.flight.ApiKey")

            /*<meta-data
            android:name="net.sharetrip.flight.ApiKey"
            android:value="7cfec5c0d66485bd27e8f50e346abb80" />*/

            if (Utils.getMD5HashString(source) == apiKey && token != null) {
                val intent = Intent(context, FlightBookingActivity::class.java)
                intent.putExtra("token", token)
                context.startActivity(intent)
            } else {
                throw Exception("ApiKey miss match")
            }
        }
    }
}
