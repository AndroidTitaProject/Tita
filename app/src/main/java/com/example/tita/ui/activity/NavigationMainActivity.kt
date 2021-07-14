package com.example.tita.ui.activity

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tita.R
import com.example.tita.databinding.ActivityNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// ViewBinding
class NavigationMainActivity : AppCompatActivity() {
    lateinit var navi: BottomNavigationView
    private lateinit var navController: NavController
    private val binding by lazy { ActivityNavigationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navi = binding.bottomNavigationView
        setSupportActionBar(binding.naviToolbar)
        navController = findNavController(R.id.navHostFragment)
        //앱 바 구성성
        val appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.homeFragment,
                        R.id.boardFragment,
                        R.id.profileFragment,
                        R.id.noticeFragment
                )
        )

        initNavigation()
        setupActionBarWithNavController(navController, appBarConfiguration)
        navi.setupWithNavController(navController)
        setToolbarColor(R.color.white)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    //Bottom Navigation Menu 가 아닐시 bottomNavigation 이 뜨질 않는다.
    private fun initNavigation() {

        val navController = findNavController(R.id.navHostFragment)
        navi.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            // fragment id 가 아닐 시 bottom navigation 안뜸
            if (destination.id == R.id.profileFragment || destination.id == R.id.homeFragment || destination.id == R.id.noticeFragment || destination.id == R.id.boardFragment) {
                navi.visibility = View.VISIBLE
            } else {
                navi.visibility = View.GONE
            }
        }
    }

    private fun setToolbarColor(colorId: Int) {
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, colorId)))
    }


}