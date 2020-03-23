package com.riccardocalligaro.forecastapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.riccardocalligaro.forecastapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set up the nav controller
        navController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        )


        // set the support action bar to the toolbar
        // setSupportActionBar(toolbar)

        // set up bottom navigation menu with the controller
        bottom_nav.setupWithNavController(navController)
        // set up action bar with nav controller
        //NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}
