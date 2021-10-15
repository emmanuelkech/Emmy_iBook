package com.example.emmy_ibook.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emmy_ibook.R
import com.example.emmy_ibook.adapter.ClickListener
import com.example.emmy_ibook.adapter.NavigationRvAdapter
import com.example.emmy_ibook.adapter.RecyclerTouchListener
import com.example.emmy_ibook.databinding.ActivityHomeScreenBinding
import com.example.emmy_ibook.model.NavigationItemModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavBar: BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var adapter: NavigationRvAdapter
    private lateinit var items: ArrayList<NavigationItemModel>

    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        bottomNavBar = binding.bottomNavigation
        bottomNavBar.setupWithNavController(navController)

        items = arrayListOf(
            NavigationItemModel(getString(R.string.donate_a_book)),
            NavigationItemModel(getString(R.string.explore_categories)),
            NavigationItemModel(getString(R.string.profile_details)),
            NavigationItemModel(getString(R.string.search))
        )

        binding.menuImage.setOnClickListener { binding.drawerLayout.openDrawer(GravityCompat.START) }
        binding.searchImage.setOnClickListener {
            navController.navigate(R.id.search)
            updateAdapter(3)
        }
        binding.signOutButton.setOnClickListener {
            startActivity(Intent(this, AuthenticationActivity::class.java))
            finish()
        }

        // Setup Recyclerview's Layout
        binding.navigationRv.layoutManager = LinearLayoutManager(this)
        binding.navigationRv.setHasFixedSize(true)

        updateAdapter(0)

        // Add Item Touch Listener
        binding.navigationRv.addOnItemTouchListener(
            RecyclerTouchListener(
                this,
                object : ClickListener {
                    override fun onClick(view: View, position: Int) {
                        when (position) {
                            0 -> {
                                // # Donate a book
                                navController.navigate(R.id.addNewBook2)
                            }
                            1 -> {
                                // # Explore Categories
                                navController.navigate(R.id.categories)
                            }
                            2 -> {
                                // # Profile Details
                                navController.navigate(R.id.profile)
                            }
                            3 -> {
                                // # Search
                                navController.navigate(R.id.search)
                            }
                        }
                        // Don't highlight the 'Profile' and 'Like us on Facebook' item row
                        if (position != 6 && position != 4) {
                            updateAdapter(position)
                        }
                        Handler(Looper.getMainLooper()).postDelayed({
                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                        }, 400)
                    }
                })
        )
    }

    private fun updateAdapter(highlightItemPos: Int) {
        adapter = NavigationRvAdapter(items, highlightItemPos)
        binding.navigationRv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}