package com.tamimattafi.pizza.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tamimattafi.pizza.android.R
import com.tamimattafi.pizza.android.presentation.fragments.menu.MenuFragment
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_Light)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragmentContainer,
            MenuFragment()
        ).commitNow()
    }
}