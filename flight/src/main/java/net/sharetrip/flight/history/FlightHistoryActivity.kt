package net.sharetrip.flight.history

import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
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

class FlightHistoryActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_of_flight)

        setSupportActionBar(findViewById(R.id.toolbar))

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_of_history_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object {
        var FLIGHT_PROMOTION_IMAGE = ""

        fun openFlightHistory(context: Context, source: String, token: String? = null) {
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

            if (Utils.getMD5HashString(source) == apiKey && token != null) {
                val intent = Intent(context, FlightHistoryActivity::class.java)
                intent.putExtra("token", token)
                context.startActivity(intent)
            } else {
                throw Exception("ApiKey miss match")
            }
        }
    }
}
