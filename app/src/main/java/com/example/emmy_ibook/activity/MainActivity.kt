package com.example.emmy_ibook.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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
import com.example.emmy_ibook.fragments.BookshelfPage

class MainActivity : AppCompatActivity() {

    private val bookshelfPage = BookshelfPage()
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

        //function to replace fragments

        replaceFragment(homeFragment)

        bottomNavBar = binding.bottomNavigation
        bottomNavBar.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_bookshelf -> replaceFragment(bookshelfPage)
               // R.id.ic_notification -> replaceFragment(Not)
            }
            true
        }


        //setCurrentFragment(homeFragment)

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id == R.id.splashScreen2){
//                binding.bottomNavigation.visibility = View.GONE
//            } else{
//                binding.bottomNavigation.visibility = View.VISIBLE
//            }
//        }
//
//        bottomNavBar.setupWithNavController(navController)

    }

    private fun replaceFragment(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val navControllerBottomNavigationView = findNavController(R.id.fragmentContainerView)

        bottomNavigationView.setupWithNavController(navControllerBottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }

    }

    override fun onBackPressed() {

    }

    

}