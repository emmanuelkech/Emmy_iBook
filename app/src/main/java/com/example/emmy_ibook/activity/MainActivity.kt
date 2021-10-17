package com.example.emmy_ibook.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Menu
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.ActivityHomeScreenBinding
import com.example.emmy_ibook.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.navigateUp
import com.example.emmy_ibook.databinding.ActivitySearchBinding

class MainActivity : AppCompatActivity() {

    private var homeFragment = HomeFragment()
    private lateinit var bottomNavBar : BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration



    private lateinit var binding: ActivityHomeScreenBinding
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        bottomNavBar = binding.bottomNavigation


        bottomNavBar.setupWithNavController(navController)

     }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchManger = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.searchMenu)?.actionView as SearchView). apply {
            setSearchableInfo(searchManger.getSearchableInfo(componentName))
        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    

}