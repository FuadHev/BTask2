package com.fuadhev.mytask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.fuadhev.mytask2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    }
    private val navController by lazy {
        navHostFragment.navController
    }
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.homeFragment), binding.drawerLayout)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setUpBottomNav()
        setUpDrawerNav()
    }
    private fun setUpDrawerNav(){
        with(binding){
            toolbar.setupWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }
    }
    private fun setUpBottomNav(){
        binding.bottomMenu.setOnItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it,navController)
            true
        }
        NavigationUI.setupWithNavController(binding.bottomMenu,navController)
    }
    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}