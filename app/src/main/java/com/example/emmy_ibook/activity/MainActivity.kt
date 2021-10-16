package com.example.emmy_ibook.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.emmy_ibook.R
import com.example.emmy_ibook.fragments.HomeFragment
import com.example.emmy_ibook.fragments.NotificationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_screen.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemReselectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){

            R.id.ic_notification -> {
                createNotificationFragment()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        createHomeFragment()

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemReselectedListener)
    }
    private fun createHomeFragment() {
        val transaction = manager.beginTransaction()
        val frag = HomeFragment()
        transaction.replace(R.id.fragment_container, frag)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createNotificationFragment() {
        val transaction = manager.beginTransaction()
        val frag = NotificationFragment()
        transaction.replace(R.id.fragment_container, frag)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}