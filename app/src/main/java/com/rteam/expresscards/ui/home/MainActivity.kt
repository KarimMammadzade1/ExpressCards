package com.rteam.expresscards.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.rteam.expresscards.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

        val configuration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController,configuration )

        toolbar.setNavigationIcon(R.drawable.backiconlast)

        toolbar.setNavigationOnClickListener {
            finish()
        }
        setSupportActionBar(toolbar)
       // supportActionBar?.setDisplayShowTitleEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(true)



    }


}