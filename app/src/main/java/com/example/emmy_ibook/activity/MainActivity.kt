package com.example.emmy_ibook.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.emmy_ibook.R
import com.example.emmy_ibook.databinding.ActivityHomeScreenBinding
import com.example.emmy_ibook.fragments.BookshelfPage
import com.example.emmy_ibook.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var homeFragment = HomeFragment()
    private var bookshelfPage = BookshelfPage()
    private lateinit var bottomNavBar : BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration


    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_book_shelf)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container ) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)
       // binding.navView.setupWithNavController(navController)

        bottomNavBar = binding.bottomNavigation
        //setCurrentFragment(homeFragment)


        replaceFragment(bookshelfPage)

        bottomNavBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_bookshelf -> replaceFragment(bookshelfPage)
               // R.id.ic_home -> replaceFragment(notification)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.commit()
    }


}