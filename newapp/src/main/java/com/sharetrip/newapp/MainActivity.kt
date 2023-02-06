package com.sharetrip.newapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val intent = Intent(this, FlightBookingActivity::class.java)
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        //startActivity(intent)
    }
}