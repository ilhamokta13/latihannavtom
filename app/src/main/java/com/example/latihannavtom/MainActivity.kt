package com.example.latihannavtom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HomeFragment=HomeFragment()
        val MessageFragment=ChatFragment()
        val SettingFragment=SettingFragment()

        setCurrentFragment(HomeFragment)
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(HomeFragment)
                R.id.message->setCurrentFragment(MessageFragment)
                R.id.settings->setCurrentFragment(SettingFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }

}
