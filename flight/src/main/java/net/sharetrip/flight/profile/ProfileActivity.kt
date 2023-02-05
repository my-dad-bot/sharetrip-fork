package net.sharetrip.flight.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import net.sharetrip.flight.R
import net.sharetrip.flight.profile.model.ProfileAction
import net.sharetrip.flight.profile.view.content.ContentFragment.Companion.ARG_FAQ_NUMBER
import net.sharetrip.flight.profile.view.content.ContentFragment.Companion.ARG_PRIVACY_POLICY
import net.sharetrip.flight.profile.view.content.ContentFragment.Companion.ARG_READ_RULES
import net.sharetrip.flight.profile.view.content.ContentFragment.Companion.ARG_TERMS_AND_CONDITION_COMMON

class ProfileActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_flight)
        setSupportActionBar(findViewById(R.id.toolbar))

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.profile_navigation_flight)
        val startDestinationArgs: Bundle = bundleOf()

        navGraph.setStartDestination(when (intent.extras?.get(ARG_PROFILE_ACTION)) {
            ProfileAction.ARG_READ_RULES -> {
                startDestinationArgs.putInt(ARG_FAQ_NUMBER, ARG_READ_RULES)
                R.id.contentFragment
            }

            ProfileAction.ARG_CONTENT_PRIVACY -> {
                startDestinationArgs.putInt(ARG_FAQ_NUMBER, ARG_PRIVACY_POLICY)
                R.id.contentFragment
            }

            ProfileAction.ARG_CONTENT_TERM -> {
                startDestinationArgs.putInt(ARG_FAQ_NUMBER, ARG_TERMS_AND_CONDITION_COMMON)
                R.id.contentFragment
            }

            else -> 0
        })

        navController.setGraph(navGraph, startDestinationArgs)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.popBackStack() || super.onSupportNavigateUp()
    }

    companion object {
        const val ARG_PROFILE_ACTION = "ProfileScreen.ProfileAction"
    }
}
