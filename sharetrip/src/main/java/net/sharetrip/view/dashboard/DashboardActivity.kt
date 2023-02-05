package net.sharetrip.view.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import net.sharetrip.R
import net.sharetrip.databinding.ActivityDashboardBinding
import net.sharetrip.flight.booking.FlightBookingActivity

class DashboardActivity : AppCompatActivity() {
    private lateinit var bindingView: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)

        val intent = Intent(this, FlightBookingActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
