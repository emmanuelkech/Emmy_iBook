package com.example.emmy_ibook.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navCon : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navCon = navHost.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navCon.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
    }
}